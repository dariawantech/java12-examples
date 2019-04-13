/**
 * Java 12 Code Examples v1 (https://www.dariawan.com)
 * Copyright (C) 2019 Dariawan <hello@dariawan.com>
 *
 * Creative Commons Attribution-ShareAlike 4.0 International License
 *
 * Under this license, you are free to: # Share - copy and redistribute the
 * material in any medium or format # Adapt - remix, transform, and build upon
 * the material for any purpose, even commercially.
 *
 * The licensor cannot revoke these freedoms as long as you follow the license
 * terms.
 *
 * License terms: # Attribution - You must give appropriate credit, provide a
 * link to the license, and indicate if changes were made. You may do so in any
 * reasonable manner, but not in any way that suggests the licensor endorses you
 * or your use. # ShareAlike - If you remix, transform, or build upon the
 * material, you must distribute your contributions under the same license as
 * the original. # No additional restrictions - You may not apply legal terms or
 * technological measures that legally restrict others from doing anything the
 * license permits.
 *
 * Notices: # You do not have to comply with the license for elements of the
 * material in the public domain or where your use is permitted by an applicable
 * exception or limitation. # No warranties are given. The license may not give
 * you all of the permissions necessary for your intended use. For example,
 * other rights such as publicity, privacy, or moral rights may limit how you
 * use the material.
 *
 * You may obtain a copy of the License at
 * https://creativecommons.org/licenses/by-sa/4.0/
 * https://creativecommons.org/licenses/by-sa/4.0/legalcode
 */
package com.dariawan.text;

import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatLocale {

    private static void printCompactNumberFormatLocale(long number) {
        NumberFormat nfDefault = NumberFormat.getCompactNumberInstance();
        NumberFormat nfUsLong = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        NumberFormat nfFrShort = NumberFormat.getCompactNumberInstance(Locale.FRANCE, NumberFormat.Style.SHORT);
        NumberFormat nfFrLong = NumberFormat.getCompactNumberInstance(Locale.FRANCE, NumberFormat.Style.LONG);
        NumberFormat nfChShort = NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.SHORT);
        NumberFormat nfChLong = NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.LONG);
        
        System.out.println("Compact Number Formatting for " + number + ":");
        System.out.println("Default:  " + nfDefault.format(number));
        System.out.println("US Long:  " + nfUsLong.format(number));
        System.out.println("FR Short: " + nfFrShort.format(number));
        System.out.println("FR Long:  " + nfFrLong.format(number));
        System.out.println("CH Short: " + nfChShort.format(number));
        System.out.println("CH Long:  " + nfChLong.format(number) + "\n");
    }

    public static void main(String[] arguments) {
        Locale[] locales = NumberFormat.getAvailableLocales();
        for (Locale locale : locales) {
            System.err.println(locale);
        }
        
        printCompactNumberFormatLocale(345600);
        printCompactNumberFormatLocale(23450000);
        printCompactNumberFormatLocale(1230000000);
    }
}
