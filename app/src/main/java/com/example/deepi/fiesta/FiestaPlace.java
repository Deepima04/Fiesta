package com.example.deepi.fiesta;

import java.io.Serializable;

/**
 * Created by Deepi on 2/11/2017.
 */
public class FiestaPlace implements Serializable
{
    String pname;


    /*public FiestaVenue getFv() {
        return fv;
    }

    public void setFv(FiestaVenue fv) {
        this.fv = fv;
    }

    FiestaVenue fv;
*/


    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    int pid;

    public FiestaPlace()
    {
        this.pname=pname;
    }

    public String toString()
    {
        return pname;
    }






}
