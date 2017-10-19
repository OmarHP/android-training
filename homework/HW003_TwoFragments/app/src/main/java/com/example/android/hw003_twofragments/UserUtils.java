package com.example.android.hw003_twofragments;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aptivist-U001 on 10/19/2017.
 */

public class UserUtils {

    private static String names[] = new String[]{"Omar", "Juan", "Karla", "Jose", "Edwin", "Alfredo", "Itzel", "Montserrat", "Aaron", "Miguel", "Laura", "Luis", "Isaias", "Enrique", "Andres", "Tania", "Pedro", "Oscar", "Diego", "Ivan", "Carlos"};
    private static String lastNames[] = new String[]{"Hernandez", "Perez", "Garcia", "Gomez", "Lopez", "Calleja", "Medina", "Carrillo", "Ledezma", "Rosales", "Castillo", "Sandoval", "Mendoza", "Escalante", "Espinosa", "Ortiz", "Martinez", "Galicia" };
    private static String digits = "0123456789";

    public static List<User> getUsersFakeData(int n){
        List<User> list = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        for(int i=0; i<n; i++){
            String name = names[random.nextInt(names.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String email = name.toLowerCase() + "." + lastName.toLowerCase()+ "@gmail.com";
            int age = random.nextInt(60)+ 20;
            StringBuilder phoneNumber = new StringBuilder();
            for(int j=0; j<10; j++){
                phoneNumber.append(digits.charAt(random.nextInt(digits.length())));
            }
            list.add(new User(name, lastName, email, phoneNumber.toString(), age));
        }
        return list;
    }


}
