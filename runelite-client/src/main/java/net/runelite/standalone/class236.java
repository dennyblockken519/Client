package net.runelite.standalone;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
public class class236 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   static Timer timer;
   @ObfuscatedName("x")
   public static final short[][] field2665;
   @ObfuscatedName("a")
   public static final short[] field2667;
   @ObfuscatedName("s")
   public static final short[][] field2668;
   @ObfuscatedName("g")
   public static final short[] field2666;

   static {
      field2667 = new short[]{(short)6798, (short)8741, (short)25238, (short)4626, (short)4550};
      field2668 = new short[][]{{(short)6798, (short)107, (short)10283, (short)16, (short)4797, (short)7744, (short)5799, (short)4634, (short)-31839, (short)22433, (short)2983, (short)-11343, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)8741, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)25239, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)25238, (short)8742, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)4626, (short)11146, (short)6439, (short)12, (short)4758, (short)10270}, {(short)4550, (short)4537, (short)5681, (short)5673, (short)5790, (short)6806, (short)8076, (short)4574, (short)17050, (short)0, (short)127, (short)-31821, (short)-17991}};
      field2666 = new short[]{(short)-10304, (short)9104, (short)-1, (short)-1, (short)-1};
      field2665 = new short[][]{{(short)6554, (short)115, (short)10304, (short)28, (short)5702, (short)7756, (short)5681, (short)4510, (short)-31835, (short)22437, (short)2859, (short)-11339, (short)16, (short)5157, (short)10446, (short)3658, (short)-27314, (short)-21965, (short)472, (short)580, (short)784, (short)21966, (short)28950, (short)-15697, (short)-14002}, {(short)9104, (short)10275, (short)7595, (short)3610, (short)7975, (short)8526, (short)918, (short)-26734, (short)24466, (short)10145, (short)-6882, (short)5027, (short)1457, (short)16565, (short)-30545, (short)25486, (short)24, (short)5392, (short)10429, (short)3673, (short)-27335, (short)-21957, (short)192, (short)687, (short)412, (short)21821, (short)28835, (short)-15460, (short)-14019}, new short[0], new short[0], new short[0]};
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lja;",
      garbageValue = "-2085451697"
   )
   public static InvType method4548(int var0) {
      InvType var1 = (InvType)InvType.field3311.method635((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvType.field3310.method4115(5, var0, 1996023546);
         var1 = new InvType();
         if(var2 != null) {
            var1.method1566(new Packet(var2));
         }

         InvType.field3311.method628(var1, (long)var0);
         return var1;
      }
   }
}
