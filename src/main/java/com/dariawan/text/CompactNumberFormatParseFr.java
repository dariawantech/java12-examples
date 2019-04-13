/**
 * Java 12 Code Examples v1 (https://www.dariawan.com)
 * Copyright (C) 2019 Dariawan <hello@dariawan.com>
 *
 * Creative Commons Attribution-ShareAlike 4.0 International License
 *
 * Under this license, you are free to:
 * # Share - copy and redistribute the material in any medium or format
 * # Adapt - remix, transform, and build upon the material for any purpose,
 *   even commercially.
 *
 * The licensor cannot revoke these freedoms
 * as long as you follow the license terms.
 *
 * License terms:
 * # Attribution - You must give appropriate credit, provide a link to the
 *   license, and indicate if changes were made. You may do so in any
 *   reasonable manner, but not in any way that suggests the licensor
 *   endorses you or your use.
 * # ShareAlike - If you remix, transform, or build upon the material, you must
 *   distribute your contributions under the same license as the original.
 * # No additional restrictions - You may not apply legal terms or
 *   technological measures that legally restrict others from doing anything the
 *   license permits.
 *
 * Notices:
 * # You do not have to comply with the license for elements of the material in
 *   the public domain or where your use is permitted by an applicable exception
 *   or limitation.
 * # No warranties are given. The license may not give you all of
 *   the permissions necessary for your intended use. For example, other rights
 *   such as publicity, privacy, or moral rights may limit how you use
 *   the material.
 *
 * You may obtain a copy of the License at
 *   https://creativecommons.org/licenses/by-sa/4.0/
 *   https://creativecommons.org/licenses/by-sa/4.0/legalcode
 */
package com.dariawan.text;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CompactNumberFormatParseFr {

    public static void main(String[] args) throws ParseException {
        NumberFormat nf = NumberFormat.getCompactNumberInstance(
                Locale.FRANCE, NumberFormat.Style.SHORT);
        String s1k = nf.format(1000);
        System.out.println("1K: " + s1k);
        System.out.println("1K: " + nf.parse(s1k));
        System.out.println("1 k".equals(s1k));
        
        System.out.println("FR/SHORT parsing:");
        System.out.println("1K: " + nf.parse("1K"));
        System.out.println("1 k: " + nf.parse("1 k"));
        System.out.println("1M: " + nf.parse("1M"));
        System.out.println("1 m: " + nf.parse("1 m"));
        System.out.println("1B: " + nf.parse("1B"));
        System.out.println("1 Md:" + nf.parse("1 Md"));

        nf = NumberFormat.getCompactNumberInstance(
                Locale.FRANCE, NumberFormat.Style.LONG);
        System.out.println("FR/LONG parsing:");
        System.out.println("1 thousand: " + nf.parse("1 thousand"));
        System.out.println("1 mille: " + nf.parse("1 mille"));
        System.out.println("1 million: " + nf.parse("1 million"));
        System.out.println("1 billion: " + nf.parse("1 billion"));
        System.out.println("1 milliard: " + nf.parse("1 milliard"));
    }
}
