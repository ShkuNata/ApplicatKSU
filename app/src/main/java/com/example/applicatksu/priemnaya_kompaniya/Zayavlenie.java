package com.example.applicatksu.priemnaya_kompaniya;

import com.google.android.material.textfield.TextInputEditText;

public class Zayavlenie {
    String surname, name,berthday, otchestvo, gender, berthplace, id;
    String numberPasport, seriyaPasport, vydanPasport, dataPasport, kodPasport;
    String gorodPropiska, stritPropiska, numberDomPropiska, numberKorpusPropiska, kvartiraPropiska;
    String gorodProzhivani, stritProzhivani, numberDomProzhivani, numberKorpusProzhivani, kvartiraProzhivani;
    String urovenObrazovania, numberObrazovania, seriyObrazovania, nameObrazovania, dateVidachi, sradniyBall;

    public Zayavlenie(String surname, String name, String berthday, String otchestvo, String gender, String berthplace, String id, String numberPasport, String seriyaPasport, String vydanPasport, String dataPasport, String kodPasport, String gorodPropiska, String stritPropiska, String numberDomPropiska, String numberKorpusPropiska, String kvartiraPropiska, String gorodProzhivani, String stritProzhivani, String numberDomProzhivani, String numberKorpusProzhivani, String kvartiraProzhivani, String numberObrazovania, String seriyObrazovania, String nameObrazovania, String dateVidachi, String sradniyBall, String urovenObrazovania) {
        this.surname = surname;
        this.name = name;
        this.berthday = berthday;
        this.otchestvo = otchestvo;
        this.gender = gender;
        this.berthplace = berthplace;
        this.id = id;
        this.numberPasport = numberPasport;
        this.seriyaPasport = seriyaPasport;
        this.vydanPasport = vydanPasport;
        this.dataPasport = dataPasport;
        this.kodPasport = kodPasport;
        this.gorodPropiska = gorodPropiska;
        this.stritPropiska = stritPropiska;
        this.numberDomPropiska = numberDomPropiska;
        this.numberKorpusPropiska = numberKorpusPropiska;
        this.kvartiraPropiska = kvartiraPropiska;
        this.gorodProzhivani = gorodProzhivani;
        this.stritProzhivani = stritProzhivani;
        this.numberDomProzhivani = numberDomProzhivani;
        this.numberKorpusProzhivani = numberKorpusProzhivani;
        this.kvartiraProzhivani = kvartiraProzhivani;
        this.urovenObrazovania = urovenObrazovania;
        this.numberObrazovania = numberObrazovania;
        this.seriyObrazovania = seriyObrazovania;
        this.nameObrazovania = nameObrazovania;
        this.dateVidachi = dateVidachi;
        this.sradniyBall = sradniyBall;
    }
    public Zayavlenie() {
        this.surname = "";
        this.name = "";
        this.otchestvo = "";
        this.gender = "";
        this.berthplace = "";
        this.id = "";
        this.berthday = "";
        this.numberPasport = "";
        this.seriyaPasport = "";
        this.vydanPasport = "";
        this.dataPasport = "";
        this.kodPasport = "";
        this.gorodPropiska = "";
        this.stritPropiska = "";
        this.numberDomPropiska = "";
        this.numberKorpusPropiska = "";
        this.kvartiraPropiska = "";
        this.gorodProzhivani = "";
        this.stritProzhivani = "";
        this.numberDomProzhivani = "";
        this.numberKorpusProzhivani = "";
        this.kvartiraProzhivani = "";
        this.urovenObrazovania = "";
        this.numberObrazovania = "";
        this.seriyObrazovania = "";
        this.nameObrazovania = "";
        this.dateVidachi = "";
        this.sradniyBall = "";
    }

    public String getUrovenObrazovania() {
        return urovenObrazovania;
    }

    public void setUrovenObrazovania(String urovenObrazovania) {
        this.urovenObrazovania = urovenObrazovania;
    }

    public String getNumberObrazovania() {
        return numberObrazovania;
    }

    public void setNumberObrazovania(String numberObrazovania) {
        this.numberObrazovania = numberObrazovania;
    }

    public String getSeriyObrazovania() {
        return seriyObrazovania;
    }

    public void setSeriyObrazovania(String seriyObrazovania) {
        this.seriyObrazovania = seriyObrazovania;
    }

    public String getNameObrazovania() {
        return nameObrazovania;
    }

    public void setNameObrazovania(String nameObrazovania) {
        this.nameObrazovania = nameObrazovania;
    }

    public String getDateVidachi() {
        return dateVidachi;
    }

    public void setDateVidachi(String dateVidachi) {
        this.dateVidachi = dateVidachi;
    }

    public String getSradniyBall() {
        return sradniyBall;
    }

    public void setSradniyBall(String sradniyBall) {
        this.sradniyBall = sradniyBall;
    }

    public String getNumberPasport() {
        return numberPasport;
    }

    public void setNumberPasport(String numberPasport) {
        this.numberPasport = numberPasport;
    }

    public String getSeriyaPasport() {
        return seriyaPasport;
    }

    public void setSeriyaPasport(String seriyaPasport) {
        this.seriyaPasport = seriyaPasport;
    }

    public String getVydanPasport() {
        return vydanPasport;
    }

    public void setVydanPasport(String vydanPasport) {
        this.vydanPasport = vydanPasport;
    }

    public String getDataPasport() {
        return dataPasport;
    }

    public void setDataPasport(String dataPasport) {
        this.dataPasport = dataPasport;
    }

    public String getKodPasport() {
        return kodPasport;
    }

    public void setKodPasport(String kodPasport) {
        this.kodPasport = kodPasport;
    }

    public String getGorodPropiska() {
        return gorodPropiska;
    }

    public void setGorodPropiska(String gorodPropiska) {
        this.gorodPropiska = gorodPropiska;
    }

    public String getStritPropiska() {
        return stritPropiska;
    }

    public void setStritPropiska(String stritPropiska) {
        this.stritPropiska = stritPropiska;
    }

    public String getNumberDomPropiska() {
        return numberDomPropiska;
    }

    public void setNumberDomPropiska(String numberDomPropiska) {
        this.numberDomPropiska = numberDomPropiska;
    }

    public String getNumberKorpusPropiska() {
        return numberKorpusPropiska;
    }

    public void setNumberKorpusPropiska(String numberKorpusPropiska) {
        this.numberKorpusPropiska = numberKorpusPropiska;
    }

    public String getKvartiraPropiska() {
        return kvartiraPropiska;
    }

    public void setKvartiraPropiska(String kvartiraPropiska) {
        this.kvartiraPropiska = kvartiraPropiska;
    }

    public String getGorodProzhivani() {
        return gorodProzhivani;
    }

    public void setGorodProzhivani(String gorodProzhivani) {
        this.gorodProzhivani = gorodProzhivani;
    }

    public String getStritProzhivani() {
        return stritProzhivani;
    }

    public void setStritProzhivani(String stritProzhivani) {
        this.stritProzhivani = stritProzhivani;
    }

    public String getNumberDomProzhivani() {
        return numberDomProzhivani;
    }

    public void setNumberDomProzhivani(String numberDomProzhivani) {
        this.numberDomProzhivani = numberDomProzhivani;
    }

    public String getNumberKorpusProzhivani() {
        return numberKorpusProzhivani;
    }

    public void setNumberKorpusProzhivani(String numberKorpusProzhivani) {
        this.numberKorpusProzhivani = numberKorpusProzhivani;
    }

    public String getKvartiraProzhivani() {
        return kvartiraProzhivani;
    }

    public void setKvartiraProzhivani(String kvartiraProzhivani) {
        this.kvartiraProzhivani = kvartiraProzhivani;
    }

    public String getBerthday() {return berthday;}
    public void setBerthday(String berthday) {
        this.berthday = berthday;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBerthplace() {
        return berthplace;
    }

    public void setBerthplace(String berthplace) {
        this.berthplace = berthplace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
