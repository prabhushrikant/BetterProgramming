package com.shrikant.problems.hashmap;

/***
 * HTTP GET /GetProductAvailability?id=<productId>
 * [true | false ]
 *
 * 5K/sec with 1 second latency 95%tile
 *
 * 1 physical server, 64GB Memory, 250GB SSD
 * NFS mount /data/ - 10PB (Network Attached Disk, 40Gbe network)
 *
 * New inventory.txt file being produced every midnight
 *
 * For example, if today Jan 01, by midnight we get inventory.txt for Jan 02,
 * by 2AM of Jan 02 we need to answer on HTTP endpoint from Jan 02 file
 *
 * /data/data-drop/2021-01-01/inventory.txt (~1TB, ~33B unique <productId>s)
 * /data/data-drop/2021-01-02/inventory.txt (~1TB, ~33B unique <productId>s)
 * /data/data-drop/2021-01-03/inventory.txt (~1TB, ~33B unique <productId>s)
 *
 * >cat inventory.txt
 *
 * AD5O08G9L863PGBSF6FU3U8945DNLP5C
 * R273LAD6IRC2V3OFDOE1Q2O4HE3LRBJV
 * 2NBJT0C0PLKHOLD3KTA3HO7JH3DDGE5L
 * 4PE5LC3TKPEJKMG0T6UHK1JS98LV9UBL
 * 2BDC6B1J90H77M53D25CTRFR9OGK0GIV
 * 37N0C603U1V6B2K77BS50LN8UNN34A4O
 * 1F4HHM9LR07BG0I52QF9PIITEM6BPMCF
 */
public class Apple {
    
}
