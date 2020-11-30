package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class PasswordGenerator {
        private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
        private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String DIGITS = "0123456789";
        private static final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";
     public PasswordGenerator() {
     }

        public String generate(int length) {
            if (length <= 0) {
                return "";
            }

            StringBuilder password = new StringBuilder(length);
            Random random = new Random(System.nanoTime());

            List<String> charCategories = new ArrayList<>(4);


            Scanner useSome = new Scanner(System.in);
            System.out.println("Do you need lower Case in your password ? (Yes/No) ");
            String lower= useSome.nextLine();

            System.out.println("Do you need upper Case in your password ? (Yes/No) ");
            String upper = useSome.nextLine();

            System.out.println("Do you need digital in your password ? (Yes/No) ");
            String digital= useSome.nextLine();

            System.out.println("Do you need punctuation in your password ? (Yes/No) ");
            String punctuation= useSome.nextLine();

            if (lower.equals("Yes") || lower.equals("yes") || lower.equals("YES")){
                charCategories.add(LOWER);
            }

            if (upper.equals("Yes") || upper.equals("yes") || upper.equals("YES")){
                charCategories.add(UPPER);
            }

            if (digital.equals("Yes") || digital.equals("yes") || digital.equals("YES")){
                charCategories.add(DIGITS);
            }
            if (punctuation.equals("Yes") || punctuation.equals("yes") || punctuation.equals("YES")){
                charCategories.add(PUNCTUATION);
            }

            for (int i = 0; i < length; i++) {
                String charCategory = charCategories.get(random.nextInt(charCategories.size()));
                int position = random.nextInt(charCategory.length());
                password.append(charCategory.charAt(position));
            }
            return new String(password);
        }
    }

