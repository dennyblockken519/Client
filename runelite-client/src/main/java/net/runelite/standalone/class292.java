package net.runelite.standalone;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class292 {
   @ObfuscatedName("b")
   static final int[] field2447;
   @ObfuscatedName("n")
   static final int[] field2448;

   static {
      field2447 = new int[2048];
      field2448 = new int[2048];
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; ++var2) {
         field2447[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
         field2448[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "-1966435559"
   )
   public static byte[] method5965(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 <= 0 || var4 >= 128) && (var4 < 160 || var4 > 255)) {
            if(var4 == 8364) {
               var2[var3] = -128;
            } else if(var4 == 8218) {
               var2[var3] = -126;
            } else if(var4 == 402) {
               var2[var3] = -125;
            } else if(var4 == 8222) {
               var2[var3] = -124;
            } else if(var4 == 8230) {
               var2[var3] = -123;
            } else if(var4 == 8224) {
               var2[var3] = -122;
            } else if(var4 == 8225) {
               var2[var3] = -121;
            } else if(var4 == 710) {
               var2[var3] = -120;
            } else if(var4 == 8240) {
               var2[var3] = -119;
            } else if(var4 == 352) {
               var2[var3] = -118;
            } else if(var4 == 8249) {
               var2[var3] = -117;
            } else if(var4 == 338) {
               var2[var3] = -116;
            } else if(var4 == 381) {
               var2[var3] = -114;
            } else if(var4 == 8216) {
               var2[var3] = -111;
            } else if(var4 == 8217) {
               var2[var3] = -110;
            } else if(var4 == 8220) {
               var2[var3] = -109;
            } else if(var4 == 8221) {
               var2[var3] = -108;
            } else if(var4 == 8226) {
               var2[var3] = -107;
            } else if(var4 == 8211) {
               var2[var3] = -106;
            } else if(var4 == 8212) {
               var2[var3] = -105;
            } else if(var4 == 732) {
               var2[var3] = -104;
            } else if(var4 == 8482) {
               var2[var3] = -103;
            } else if(var4 == 353) {
               var2[var3] = -102;
            } else if(var4 == 8250) {
               var2[var3] = -101;
            } else if(var4 == 339) {
               var2[var3] = -100;
            } else if(var4 == 382) {
               var2[var3] = -98;
            } else if(var4 == 376) {
               var2[var3] = -97;
            } else {
               var2[var3] = 63;
            }
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }
}
