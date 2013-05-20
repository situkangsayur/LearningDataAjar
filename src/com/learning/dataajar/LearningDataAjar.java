/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learning.dataajar;

import com.learning.dataajar.model.EntropyModel;

import com.learning.dataajar.entities.EntropyEntity;
import com.learning.dataajar.entities.GainsEntity;
import com.learning.dataajar.entities.QueryParamters;
import com.learning.dataajar.entities.Datanilai;
import com.learning.dataajar.entities.TreeNode;
import com.learning.dataajar.model.GainsModel2;
import com.learning.dataajar.services.Attribute;
import com.learning.dataajar.services.Database;
import com.learning.dataajar.services.HelpAttribute;
import com.learning.dataajar.services.InputFileService;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author hendri
 */
public class LearningDataAjar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //List<Attribute> list = HelpAttribute.getAtribut();
        int step = 0;
        int numOfNode = 0;
        int nodeStep = 0;
        //databases control

        EntityManager manager;
        Query query;
        List<Datanilai> mainDataSet = null;
        String queryString;


        EntropyModel model;
        EntropyModel modelRoot = new EntropyModel();
        GainsModel2 modelGains;
        EntropyEntity parent = new EntropyEntity();

        //treeNode
        TreeNode mainNode = new TreeNode();
        mainNode.setDeepLevel(1);
        manager = Database.getEntityManager();

        int possible = 1;
        int pos = 0;
        List<String> list = new ArrayList<String>();
        InputFileService.setList(list);

        while ((HelpAttribute.checkState() > 0) && (possible != 0)) {
//            System.out.println("iterasi : " + pos++);
            try{
            InputFileService.getList().add("iterasi : " + (pos++) +"\n");
            model = new EntropyModel();
            modelGains = new GainsModel2();
            System.out.println("iterasi : " + pos++);



            if (step == 0) {
                possible = 0;
                queryString = "SELECT t FROM Datanilai t";
                query = manager.createQuery(queryString);
                mainDataSet = query.getResultList();

                modelRoot.setDataSet(mainDataSet);
                modelRoot.countProportion(20);
                modelRoot.countFirstEntropy();
                parent = modelRoot.getEntropyEnt();

                mainNode.setQueryNode(queryString);
                for (Datanilai data : mainDataSet) {
                    String result = " -- " + data.getNim() + "--"
                            + data.getNama()
                            + "--"
                            + data.getNilai1()
                            + "--"
                            + data.getNilai2() + "--"
                            + data.getNilai3() + "--"
                            + data.getNilai4() + "--"
                            + data.getNilai5() + "--"
                            + data.getNilai6() + "--"
                            + data.getNilai7() + "--"
                            + data.getNilai8() + "--"
                            + data.getNilai9() + "--"
                            + data.getNilai10() + "--"
                            + data.getNilai11() + "--"
                            + data.getNilai12() + "--"
                            + data.getNilai13() + "--"
                            + data.getNilai14() + "--"
                            + data.getNilai15() + "--"
                            + data.getNilai16() + "--"
                            + data.getNilai17() + "--"
                            + data.getNilai18() + "--"
                            + data.getIsLulusTepatWaktu();
                    System.out.println(result);
                    InputFileService.getList().add(result+"\n");
                }


            } else {
                if (mainNode.getNode() == null) {
                    System.out.println("=============================================================");
                    InputFileService.getList().add("=============================================================\n");
                    System.out.println(" level = " + mainNode.getDeepLevel());
                    InputFileService.getList().add(" level = " + mainNode.getDeepLevel()+"\n");
                    System.out.println("=============================================================");
                    InputFileService.getList().add("=============================================================\n");
                    String parentValue = mainNode.getEntropyParent().getValueName();
                    Integer numField = mainNode.getParentNode().getNumField();
                    String parentField = HelpAttribute.getAtribut().get(numField).getAttribute();
                    String original = parentField;
                    if (parentField.indexOf("_") != -1) {
                        parentField = parentField.substring(0, parentField.indexOf("_"))
                                + parentField.substring(parentField.indexOf("_") + 1, parentField.indexOf("_") + 2).toUpperCase()
                                + parentField.substring(parentField.indexOf("_") + 2, parentField.length()).toLowerCase();

                    }

                    String paramField = parentField.substring(0, 1).toLowerCase()
                            + parentField.substring(1, parentField.length());
                    // System.out.println(paramField);
                    paramField = paramField.trim();
                    paramField = paramField.toLowerCase();

                    if (mainNode.getDeepLevel() == 2) {

                        queryString = mainNode.getParentNode().getQueryNode() + " WHERE t." + paramField
                                + " = :" + paramField;
                        //  System.out.println(queryString);
                    } else {

                        queryString = mainNode.getParentNode().getQueryNode();
                        queryString += " and t." + paramField + " = :" + paramField;

                    }
                    query = manager.createQuery(queryString);

                    List<QueryParamters> params;

                    if (mainNode.getParentNode().getParameters() != null) {
                        params = new ArrayList<QueryParamters>(mainNode.getParentNode().getParameters());
                    } else {
                        params = new ArrayList<QueryParamters>();
                    }


                    QueryParamters newParam = new QueryParamters();
                    newParam.setParameter(paramField);
                    newParam.setValue(parentValue);
                    params.add(newParam);


                    for (QueryParamters qr : params) {
                        query.setParameter(qr.getParameter(), (Object) qr.getValue());

                    }


                    List<Datanilai> subSet = query.getResultList();

                    mainNode.setQueryNode(queryString);
                    mainNode.setParameters(params);

                    mainDataSet = subSet;
                    modelRoot = new EntropyModel();
                    modelRoot.setDataSet(subSet);
                    modelRoot.countProportion(5);
                    modelRoot.countFirstEntropy();
                    parent = modelRoot.getEntropyEnt();


                    for (Datanilai data : mainDataSet) {
                        String result = " -- " + data.getNim() + "--"
                                + data.getNama()
                                + "--"
                                + data.getNilai1()
                                + "--"
                                + data.getNilai2() + "--"
                                + data.getNilai3() + "--"
                                + data.getNilai4() + "--"
                                + data.getNilai5() + "--"
                                + data.getNilai6() + "--"
                                + data.getNilai7() + "--"
                                + data.getNilai8() + "--"
                                + data.getNilai9() + "--"
                                + data.getNilai10() + "--"
                                + data.getNilai11() + "--"
                                + data.getNilai12() + "--"
                                + data.getNilai13() + "--"
                                + data.getNilai14() + "--"
                                + data.getNilai15() + "--"
                                + data.getNilai16() + "--"
                                + data.getNilai17() + "--"
                                + data.getNilai18() + "--"
                                + data.getIsLulusTepatWaktu();
                        System.out.println(result);
                        InputFileService.getList().add(result+"\n");
                    }
                }

            }

            ///run main logic
            if (mainNode.getNode() == null) {
                System.out.println("");
                InputFileService.getList().add("\n");

                modelGains.setParentEntropy(parent);
                //   modelGains.setTargetEntropy(allEnt);
                modelGains.setSubSet(mainDataSet);
                modelGains.countGains();

                for (GainsEntity data : modelGains.getGains()) {
                    System.out.println("--------->> gain => " + HelpAttribute.getAtribut().get(data.getNumField()).getAttribute() + " : " + data.getGains());
                    InputFileService.getList().add("--------->> gain => " + HelpAttribute.getAtribut().get(data.getNumField()).getAttribute() + " : " + data.getGains()+"\n");
                    
                }

                GainsEntity biggestGains = modelGains.biggestValue();

                System.out.println("------------>>>biggest gains : " + HelpAttribute.getAtribut().get(modelGains.biggestValue().getNumField()).getAttribute()
                        + " with gains = " + biggestGains.getGains());
                InputFileService.getList().add("------------>>>biggest gains : " + HelpAttribute.getAtribut().get(modelGains.biggestValue().getNumField()).getAttribute()
                        + " with gains = " + biggestGains.getGains()+"\n");

                System.out.println("hasil dari biggest val : " + modelGains.biggestValue().getNumField());
                InputFileService.getList().add("hasil dari biggest val : " + modelGains.biggestValue().getNumField()+"\n");

                mainNode.setNumField(modelGains.biggestValue().getNumField());

                //mainNode.setGainParent(biggestGains);
                //mainNode.setEntropyParent(biggestGains.getEntropyParent());
                mainNode.setChecking(true);

                List<TreeNode> childs = new ArrayList<TreeNode>();

                numOfNode = biggestGains.getEntropyTarget().size();



                for (int i = 0; i < numOfNode; i++) {
                    TreeNode tempNode = new TreeNode();
                    possible++;
                    //check direct value that not need any leaf
                    //set information value
                    tempNode.setEntropyParent(biggestGains.getEntropyTarget().get(i));
                    tempNode.setGainParent(biggestGains);
                    //parent value

                    tempNode.setTotalOfValue(numOfNode);
                    //alternative that this not done                
                    tempNode.setResultValue(null);
                    tempNode.setChecking(false);
                    tempNode.setDeepLevel(mainNode.getDeepLevel() + 1);

                    int temp = 0;
                    boolean solidVal = false;

                    for (int j = 0; j < biggestGains.getEntropyTarget().get(i).getSpecVal().size(); j++) {

                        // System.out.println(biggestGains.getEntropyTarget().get(i).getSpecVal().size());

                        temp += biggestGains.getEntropyTarget().get(i).getSpecVal().get(j);

                        //   System.out.println("val part  " + j + " : " + biggestGains.getEntropyTarget().get(i).getSpecVal().get(j));

                        if (biggestGains.getEntropyTarget().get(i).getSpecVal().get(j) == 0) {
                            //     System.out.println(" ada nol");
                            solidVal = true;
                        }
                        if (solidVal) {
                            tempNode.setChecking(true);
                            tempNode.setNode(null);
                            tempNode.setNumField(null);
                            tempNode.setResultValue(temp);

                        }

                    }

                    tempNode.setParentNode(mainNode);
                    childs.add(tempNode);
                }

                mainNode.setNode(childs);


            }

            boolean doneCon = false;
            int iterator = 0;


            for (iterator = 0; iterator < mainNode.getNode().size(); iterator++) {

                if (mainNode.getNode().get(iterator).getResultValue() == null) {
                    //     System.out.println(" result null " + mainNode.getNode().get(iterator).getEntropyParent().getValueName());
                    if (!mainNode.getNode().get(iterator).isChecking()) {
                        //       System.out.println(" result false " + mainNode.getNode().get(iterator).getEntropyParent().getValueName());
                        break;
                    } else {
                        possible--;
                        if (iterator < mainNode.getNode().size() - 1) {
                            //         System.out.println("next");

                            continue;
                        }
                        //      System.out.println("pass");
                    }
                } else {

                    if (iterator < (mainNode.getNode().size() - 1)) {
                        System.out.println("next");
                        InputFileService.getList().add("next\n");
                        possible--;
                        continue;
                    }
                }
                doneCon = true;

            }
            // System.out.println("iterator after = " + iterator);


            if (!doneCon) {
                System.out.println("forward");
                InputFileService.getList().add("forward\n");
                mainNode = mainNode.getNode().get(iterator);

            } else {
                System.out.println("backward");
                InputFileService.getList().add("backward\n");

                mainNode = mainNode.getParentNode();
                //System.out.println(HelpAttribute.getAtribut().get(mainNode.getNumField()).getAttribute());
            }
            // Stringtok
            System.out.println("end");
            InputFileService.getList().add("end\n");
            step++;
            }catch(Exception e){
                e.printStackTrace();
                break;
            }finally{
                InputFileService.printToFile("TreeResult.txt", InputFileService.getList());
            }
        }
        InputFileService.printToFile("TreeResult.txt", InputFileService.getList());
    }
}
