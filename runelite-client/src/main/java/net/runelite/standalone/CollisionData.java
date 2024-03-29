package net.runelite.standalone;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSCollisionData;

@ObfuscatedName("fk")
public class CollisionData implements RSCollisionData {
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 336385347
   )
   int width;
   @ObfuscatedName("au")
   public int[][] flags;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -106970989
   )
   int height;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1710257743
   )
   public int x;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -882717619
   )
   public int y;

   public CollisionData(int var1, int var2) {
      this.x = 0;
      this.y = 0;
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method3599();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1541645069"
   )
   void method3594(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2099037654"
   )
   void method3591(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1978583570"
   )
   public void method3587(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)V",
      garbageValue = "1"
   )
   public void method3603(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.width) {
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.height) {
                  this.method3591(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1569384577"
   )
   public void method3589(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method3591(var1, var2, 128);
            this.method3591(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method3591(var1, var2, 2);
            this.method3591(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method3591(var1, var2, 8);
            this.method3591(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method3591(var1, var2, 32);
            this.method3591(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method3591(var1, var2, 1);
            this.method3591(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method3591(var1, var2, 4);
            this.method3591(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method3591(var1, var2, 16);
            this.method3591(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method3591(var1, var2, 64);
            this.method3591(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method3591(var1, var2, 130);
            this.method3591(var1 - 1, var2, 8);
            this.method3591(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method3591(var1, var2, 10);
            this.method3591(var1, var2 + 1, 32);
            this.method3591(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method3591(var1, var2, 40);
            this.method3591(var1 + 1, var2, 128);
            this.method3591(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method3591(var1, var2, 160);
            this.method3591(var1, var2 - 1, 2);
            this.method3591(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method3591(var1, var2, 65536);
               this.method3591(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method3591(var1, var2, 1024);
               this.method3591(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method3591(var1, var2, 4096);
               this.method3591(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method3591(var1, var2, 16384);
               this.method3591(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method3591(var1, var2, 512);
               this.method3591(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method3591(var1, var2, 2048);
               this.method3591(var1 + 1, var2 + 1, 32768);
            }

            if(var4 == 2) {
               this.method3591(var1, var2, 8192);
               this.method3591(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method3591(var1, var2, 32768);
               this.method3591(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method3591(var1, var2, 66560);
               this.method3591(var1 - 1, var2, 4096);
               this.method3591(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method3591(var1, var2, 5120);
               this.method3591(var1, var2 + 1, 16384);
               this.method3591(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method3591(var1, var2, 20480);
               this.method3591(var1 + 1, var2, 65536);
               this.method3591(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method3591(var1, var2, 81920);
               this.method3591(var1, var2 - 1, 1024);
               this.method3591(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-125357878"
   )
   public void method3592(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "111216585"
   )
   public void method3599() {
      for(int var1 = 0; var1 < this.width; ++var1) {
         for(int var2 = 0; var2 < this.height; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.width - 5 && var2 < this.height - 5) {
               this.flags[var1][var2] = 16777216;
            } else {
               this.flags[var1][var2] = 16777215;
            }
         }
      }

   }

   public int[][] getFlags() {
      return this.flags;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1656672999"
   )
   public void method3598(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method3594(var1, var2, 128);
            this.method3594(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method3594(var1, var2, 2);
            this.method3594(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method3594(var1, var2, 8);
            this.method3594(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method3594(var1, var2, 32);
            this.method3594(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method3594(var1, var2, 1);
            this.method3594(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method3594(var1, var2, 4);
            this.method3594(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method3594(var1, var2, 16);
            this.method3594(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method3594(var1, var2, 64);
            this.method3594(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method3594(var1, var2, 130);
            this.method3594(var1 - 1, var2, 8);
            this.method3594(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method3594(var1, var2, 10);
            this.method3594(var1, var2 + 1, 32);
            this.method3594(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method3594(var1, var2, 40);
            this.method3594(var1 + 1, var2, 128);
            this.method3594(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method3594(var1, var2, 160);
            this.method3594(var1, var2 - 1, 2);
            this.method3594(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method3594(var1, var2, 65536);
               this.method3594(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method3594(var1, var2, 1024);
               this.method3594(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method3594(var1, var2, 4096);
               this.method3594(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method3594(var1, var2, 16384);
               this.method3594(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method3594(var1, var2, 512);
               this.method3594(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method3594(var1, var2, 2048);
               this.method3594(var1 + 1, var2 + 1, 32768);
            }

            if(var4 == 2) {
               this.method3594(var1, var2, 8192);
               this.method3594(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method3594(var1, var2, 32768);
               this.method3594(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method3594(var1, var2, 66560);
               this.method3594(var1 - 1, var2, 4096);
               this.method3594(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method3594(var1, var2, 5120);
               this.method3594(var1, var2 + 1, 16384);
               this.method3594(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method3594(var1, var2, 20480);
               this.method3594(var1 + 1, var2, 65536);
               this.method3594(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method3594(var1, var2, 81920);
               this.method3594(var1, var2 - 1, 1024);
               this.method3594(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1713451789"
   )
   public void method3597(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "1"
   )
   public void method3586(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.method3594(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("ky")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1208395324"
   )
   static final void method3613() {
      client.field898 = client.cycleCntr;
      WorldMapDecoration.field225 = true;
   }
}
