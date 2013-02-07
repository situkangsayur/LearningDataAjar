/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learning.dataajar.model;

import com.learning.dataajar.entities.EntropyEntity;
import com.learning.dataajar.entities.ResultEntity;
import com.learning.dataajar.entities.ResultHelp;
import com.learning.dataajar.entities.EntStatistic;
import com.learning.dataajar.entities.DataNilai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hendri
 */
public class EntropyModel {

    private EntropyEntity entropyEnt;
    private List<DataNilai> dataSet;
    private Integer field;
    private List<EntStatistic> proportion;

    public void setDataSet(List<DataNilai> dataSet) {
        this.dataSet = dataSet;
    }

    public void countProportion(int numField) {
        this.field = numField;

        String current = null;
        proportion = new ArrayList<EntStatistic>();

        List<Integer> resuList = null;

        if (this.field == 5) {
            resuList = new ArrayList<Integer>();
        }

        for (DataNilai data : dataSet) {
            switch (this.field) {
                case 0:
                    current = data.getNim();
                    break;
                case 1:
                    current = data.getNama();
                    break;
                case 2:
                    current = data.getNilaiMataKuliahAgama();
                    break;
                case 3:
                    current = data.getNilaiMataKuliahAlgoritmaPemrograman1();
                    break;
                case 4:
                    current = data.getNilaiMataKuliahAlgoritmaPemrograman2();
                    break;
                case 5:
                    current = data.getNilaiMataKuliahAplikasiIt1();
                    break;
                case 6:
                    current = data.getNilaiMataKuliahAplikasiIt2();
                    break;
                case 7:
                    current = data.getNilaiMataKuliahBahasaInggris();
                    break;
                case 8:
                    current = data.getNilaiMataKuliahFisikaDasar1();
                    break;
                case 9:
                    current = data.getNilaiMataKuliahFisikaDasar2();
                    break;
                case 10:
                    current = data.getNilaiMataKuliahKalkulus1();
                    break;
                case 11:
                    current = data.getNilaiMataKuliahKalkulus2();
                    break;
                case 12:
                    current = data.getNilaiMataKuliahKonsepTeknologi();
                    break;
                case 13:
                    current = data.getNilaiMataKuliahPancasila();
                    break;
                case 14:
                    current = data.getNilaiMataKuliahPengantarIlmuKomputer();
                    break;
                case 15:
                    current = data.getNilaiMataKuliahPraktikumFisikaDasar1();
                    break;
                case 16:
                    current = data.getNilaiMataKuliahPraktikumFisikaDasar2();
                    break;
                case 17:
                    current = data.getNilaiMataKuliahSoftwareTerapan1();
                    break;
                case 18:
                    current = data.getNilaiMataKuliahSoftwareTerapan2();
                    break;
                case 19:
                    current = data.getNilaiMataKuliahStatistikaProbabilitas();
                    break;
                case 20:
                    current = data.getMasaStudi();
                    break;
                case 21:
                    current = data.getIsLulusTepatWaktu();
                    break;
            }


            if (this.field != 5) {

                if (proportion.size() == 0) {

                    EntStatistic statistic = new EntStatistic();
                    statistic.setAttribute(current);
                    statistic.setCount(1);
                    int now = ResultEntity.findResult(data.getPlayTennis());

                    statistic.getResult().set(now, 1);
                    proportion.add(statistic);
                } else {
                    int i = 0;
                    boolean pass = false;
                    for (i = 0; i < proportion.size(); i++) {

                        if (proportion.get(i).getAttribute().equals(current)) {

                            int now = ResultEntity.findResult(data.getPlayTennis());

                            proportion.get(i).getResult().set(now,
                                    proportion.get(i).getResult().get(now) + 1);


                            proportion.get(i).setCount(proportion.get(i).getCount());
                            pass = true;
                            break;
                        }
                    }
                    if (pass == false) {

                        int now = ResultEntity.findResult(data.getPlayTennis());

                        EntStatistic statistic = new EntStatistic();
                        statistic.setAttribute(current);
                        statistic.setCount(1);

                        statistic.getResult().set(now, 1);


                        proportion.add(statistic);
                    }
                }

            } else { // first entropy
                if (proportion.size() == 0) {


                    ResultEntity.setDone(false);
                    EntStatistic statistic = new EntStatistic();
                    statistic.setAttribute(current);
                    ResultEntity.getVal().add(current);
                    statistic.setCount(1);
                    statistic.getResult().add(1);
                    proportion.add(statistic);

                } else {
                    int i;
                    boolean pass = false;
                    for (i = 0; i < proportion.size(); i++) {


                        if (proportion.get(i).getAttribute().equalsIgnoreCase(current)) {


                            int now = ResultEntity.findResult(data.getPlayTennis());

                            proportion.get(i).getResult().set(0,
                                    proportion.get(i).getResult().get(0) + 1);

                            proportion.get(i).setCount(proportion.get(i).getCount() + 1);



                            pass = true;
                            break;
                        }
                    }

                    if (pass == false) {

                        EntStatistic statistic = new EntStatistic();
                        statistic.setAttribute(current);
                        ResultEntity.getVal().add(current);

                        statistic.getResult().add(1);

                        statistic.setCount(1);


                        proportion.add(statistic);
                    }

                }
            }

        }
        if (this.field == 5) {
            ResultEntity.setDone(true);
        }


    }

    public void countFirstEntropy() {
        entropyEnt = new EntropyEntity();
        entropyEnt.setAllVal(proportion.get(0).getCount());
        Integer allCount = 0;
        int tempSpecVal = 0;
        List<Integer> specVal = new ArrayList<Integer>();


        for (int i = 0; i < proportion.size(); i++) {

            //allCount += proportion.get(j).getResult();

            if (this.field != 5) {
                for (int j = 0; j < ResultEntity.getVal().size(); j++) {
                    tempSpecVal += proportion.get(i).getResult().get(j);
                }


            } else {

                tempSpecVal = proportion.get(i).getResult().get(0);
            }
            allCount += tempSpecVal;

            specVal.add(tempSpecVal);
        }

        entropyEnt.setAllVal(allCount);
        entropyEnt.setSpecVal(specVal);
        entropyEnt.entropyFirstProgress();

    }

    public List<EntropyEntity> countAllEntropy() {

//        entropyEnt.setAllVal(proportion.get(0).getCount());
        Integer allCount = 0;
        int tempSpecVal = 0;



        List<EntropyEntity> allEnt = new ArrayList<EntropyEntity>();

        for (int i = 0; i < proportion.size(); i++) {
            allCount = 0;
            tempSpecVal = 0;
            //allCount += proportion.get(j).getResult();
            EntropyEntity entEnt = new EntropyEntity();
            List<Integer> specVal = new ArrayList<Integer>();
            if (this.field != 5) {
                for (int j = 0; j < ResultEntity.getVal().size(); j++) {
                    tempSpecVal = proportion.get(i).getResult().get(j);
                    specVal.add(tempSpecVal);
                    allCount += tempSpecVal;
                }


            } else {
                System.out.println("errorr");
                break;
            }

            entEnt.setAllVal(allCount);
            entEnt.setSpecVal(specVal);
            entEnt.entropyFirstProgress();
            entEnt.setValueName(proportion.get(i).getAttribute());
            entEnt.setNumValue(i);
            allEnt.add(entEnt);
        }
        return allEnt;


    }

    public EntropyEntity getEntropyEnt() {
        return entropyEnt;
    }
}
