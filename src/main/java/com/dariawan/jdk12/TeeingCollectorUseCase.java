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
package com.dariawan.jdk12;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class TeeingCollectorUseCase {

    public static void main(String[] args) {
        var result = Stream.of(
                // City(String name, String region, Integer costOfLiving)
                new City("Colombo", "South Asia", 987),
                new City("Da Lat", "South East Asia", 914),
                new City("Kiev", "Eastern Europe", 1334),
                new City("Melbourne", "Australia", 3050),
                new City("Shanghai", "East Asia", 1998),
                new City("Taghazout", "North Africa", 1072),
                new City("Ubud", "South East Asia", 1331))
                .collect(Collectors.teeing(
                        // first collector, select cities in Asia 
                        // with monthly cost of living less than 1000$
                        Collectors.filtering(
                                o -> ((City) o).region.contains("Asia") && 
                                        ((City) o).costOfLiving <= 1000,
                                // collect the name in a list
                                Collectors.mapping(o -> ((City) o).name, Collectors.toList())),
                        // second collector, count the number of those cities
                        Collectors.filtering(
                                o -> ((City) o).region.contains("Asia") &&
                                        ((City) o).costOfLiving <= 1000,
                                counting()),
                        // merge the collectors, put into a String
                        (l, c) -> "Result[cities=" + l + ", count=" + c + "]"));

        System.out.println(result);
        // Result[cities=[Colombo, Da Lat], count=2]
    }

    static class City {

        private final String name;
        private final String region;
        private final Integer costOfLiving;

        public City(String name, String region,
                Integer costOfLiving) {
            this.name = name;
            this.region = region;
            this.costOfLiving = costOfLiving;
        }

        public String getRegion() {
            return region;
        }

        public Integer getCostOfLiving() {
            return costOfLiving;
        }
    }
}
