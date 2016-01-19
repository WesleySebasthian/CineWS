/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.negocio;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Wesley
 */
public class ConverteData {

    public static Time StringForTime(String hora) throws ParseException {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Time horaSql = new Time(format.parse(hora).getTime());
        return horaSql;
    }

    public static String TimeForString(Time hora) throws ParseException {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        String horaString = format.format(hora);
        return horaString;
    }

    public static Date StringForDate(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataSql = new Date(format.parse(data).getTime());
        return dataSql;
    }

    public static String DateForString(Date data) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = format.format(data);
        return dataString;
    }
}
