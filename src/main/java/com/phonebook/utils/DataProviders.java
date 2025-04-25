package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {


    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Bony", "Klaid", "0434656756", "bony_s@mail.net", "Hamburg", "QA"});
        list.add(new Object[]{"Bony", "Klaid", "0434656745", "bon_s@mail.net", "Hamburg", "QA"});
        list.add(new Object[]{"Bony", "Klaid", "043465674537", "byny_s@mail.net", "Hamburg", "QA"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> addNewContactWithCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/Contactdata.csv")));

        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0])
                    .setLastName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();

    }
}
