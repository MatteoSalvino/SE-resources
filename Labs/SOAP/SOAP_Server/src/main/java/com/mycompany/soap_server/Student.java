/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap_server;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author studente
 */
@XmlJavaTypeAdapter(StudentAdapter.class)
public interface Student {
    public String getName();
}
