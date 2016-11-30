package com.company;


import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Customer customer = new Customer();

        File load = new File("surveyAnswers.json");
        Scanner loading = null;
        try {
            loading = new Scanner(load);
            loading.useDelimiter("\\Z");
            String loadAnswers = loading.next();
            JsonParser savedAnswers = new JsonParser();
            customer = savedAnswers.parse(loadAnswers, Customer.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (customer.ans1 == null) {
            System.out.println("Hello Customer");
            System.out.println("\nWould you like to take a survey regarding your purchase? [y/n]:");
            String takeSurvey = scanner.nextLine();

            if (takeSurvey.equalsIgnoreCase("y")) {

                System.out.println("Survey Question [1]\nAre you satisfied with your purchase? [y/n]");
                customer.ans1 = scanner.nextLine();

                System.out.println("Survey Question [2]\nWas the setup for the product difficult? [y/n]");
                customer.ans2 = scanner.nextLine();

                System.out.println("Survey Question [3]\nDid the product work as advertised? [y/n]");
                customer.ans3 = scanner.nextLine();

                System.out.println("Survey Question [4]\nWould you recommend this product to friend/relative? [y/n]");
                customer.ans4 = scanner.nextLine();

                System.out.println("Survey Question [5]\nWill you purchase from this company again in the future? [y/n]");
                customer.ans5 = scanner.nextLine();

                File save = new File("surveyAnswers.json");

                JsonSerializer serializer = new JsonSerializer();
                String answers = serializer.serialize(customer);
                FileWriter fw = new FileWriter(save);
                fw.write(answers);
                fw.close();

                Scanner submitAnswers = new Scanner(save);
                submitAnswers.useDelimiter("\\Z");
                String saveAnswers = submitAnswers.next();
                System.out.println(saveAnswers);

            } else if (takeSurvey.equalsIgnoreCase("n")) {
                System.out.println("Thank you for not contributing to product improvement and future development...\n    Have a spectacular day!");

            }
        } else {
            System.out.println("Welcome back Customer. Here are your survey responses:");
            System.out.println("[1] " + customer.ans1);
            System.out.println("[2] " + customer.ans2);
            System.out.println("[3] " + customer.ans3);
            System.out.println("[4] " + customer.ans4);
            System.out.println("[5] " + customer.ans5);
            System.out.println("\nWould you like to update your answers? [y/n]");
            String updateSurvey = scanner.nextLine();
            if (updateSurvey.equalsIgnoreCase("y")) {

                System.out.println("Survey Question [1]\nAre you satisfied with your purchase? [y/n]");
                customer.ans1 = scanner.nextLine();

                System.out.println("Survey Question [2]\nWas the setup for the product difficult? [y/n]");
                customer.ans2 = scanner.nextLine();

                System.out.println("Survey Question [3]\nDid the product work as advertised? [y/n]");
                customer.ans3 = scanner.nextLine();

                System.out.println("Survey Question [4]\nWould you recommend this product to friend/relative? [y/n]");
                customer.ans4 = scanner.nextLine();

                System.out.println("Survey Question [5]\nWill you purchase from this company again in the future? [y/n]");
                customer.ans5 = scanner.nextLine();

                System.out.println("Thank you for contributing to product improvement and future development...\n    Have a spectacular day!");

                File save = new File("surveyAnswers.json");

                JsonSerializer serializer = new JsonSerializer();
                String answers = serializer.serialize(customer);
                FileWriter fw = new FileWriter(save);
                fw.write(answers);
                fw.close();

                Scanner submitAnswers = new Scanner(save);
                submitAnswers.useDelimiter("\\Z");
                String saveAnswers = submitAnswers.next();
            } else if (updateSurvey.equalsIgnoreCase("n")) {
                System.out.println("Thank you for contributing to product improvement and future development...\n    Have a spectacular day!");

            }
        }
    }
}
