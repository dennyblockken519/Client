package net.runelite.standalone;

import java.util.Random;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class AudioInstrument {
   @ObfuscatedName("v")
   static int[] AUDIO_SINE;
   @ObfuscatedName("k")
   static int[] NOISE;
   @ObfuscatedName("w")
   static int[] phases;
   @ObfuscatedName("z")
   static int[] pitchBaseSteps;
   @ObfuscatedName("c")
   static int[] volumeSteps;
   @ObfuscatedName("i")
   static int[] delays;
   @ObfuscatedName("y")
   static int[] samples;
   @ObfuscatedName("j")
   static int[] pitchSteps;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   AudioEnvelope volumeMultiplierAmplitude;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   AudioEnvelope filterEnvelope;
   @ObfuscatedName("e")
   int delayTime;
   @ObfuscatedName("r")
   int delayDecay;
   @ObfuscatedName("q")
   int[] oscillatorVolume;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   AudioEnvelope pitchModifierAmplitude;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   AudioEnvelope field1501;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   AudioEnvelope release;
   @ObfuscatedName("b")
   int[] oscillatorPitch;
   @ObfuscatedName("o")
   int duration;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   AudioEnvelope pitch;
   @ObfuscatedName("n")
   int[] oscillatorDelays;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   SoundEffect3 filter;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   AudioEnvelope volume;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   AudioEnvelope volumeMultiplier;
   @ObfuscatedName("u")
   int offset;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   AudioEnvelope pitchModifier;

   static {
      NOISE = new int['耀'];
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < 32768; ++var1) {
         NOISE[var1] = (var0.nextInt() & 2) - 1;
      }

      AUDIO_SINE = new int['耀'];

      for(var1 = 0; var1 < 32768; ++var1) {
         AUDIO_SINE[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      samples = new int[220500];
      phases = new int[5];
      delays = new int[5];
      volumeSteps = new int[5];
      pitchSteps = new int[5];
      pitchBaseSteps = new int[5];
   }

   AudioInstrument() {
      this.oscillatorVolume = new int[]{0, 0, 0, 0, 0};
      this.oscillatorPitch = new int[]{0, 0, 0, 0, 0};
      this.oscillatorDelays = new int[]{0, 0, 0, 0, 0};
      this.delayTime = 0;
      this.delayDecay = 100;
      this.duration = 500;
      this.offset = 0;
   }

   @ObfuscatedName("a")
   final int[] method990(int var1, int var2) {
      class11.method171(samples, 0, var1);
      if(var2 < 10) {
         return samples;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.pitch.method2333();
         this.volume.method2333();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.pitchModifier != null) {
            this.pitchModifier.method2333();
            this.pitchModifierAmplitude.method2333();
            var5 = (int)((double)(this.pitchModifier.end - this.pitchModifier.start) * 32.768D / var3);
            var6 = (int)((double)this.pitchModifier.start * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.volumeMultiplier != null) {
            this.volumeMultiplier.method2333();
            this.volumeMultiplierAmplitude.method2333();
            var8 = (int)((double)(this.volumeMultiplier.end - this.volumeMultiplier.start) * 32.768D / var3);
            var9 = (int)((double)this.volumeMultiplier.start * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.oscillatorVolume[var11] != 0) {
               phases[var11] = 0;
               delays[var11] = (int)((double)this.oscillatorDelays[var11] * var3);
               volumeSteps[var11] = (this.oscillatorVolume[var11] << 14) / 100;
               pitchSteps[var11] = (int)((double)(this.pitch.end - this.pitch.start) * 32.768D * Math.pow(1.0057929410678534D, (double)this.oscillatorPitch[var11]) / var3);
               pitchBaseSteps[var11] = (int)((double)this.pitch.start * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.pitch.method2334(var1);
            var13 = this.volume.method2334(var1);
            if(this.pitchModifier != null) {
               var14 = this.pitchModifier.method2334(var1);
               var15 = this.pitchModifierAmplitude.method2334(var1);
               var12 += this.method991(var7, var15, this.pitchModifier.form) >> 1;
               var7 = var7 + var6 + (var14 * var5 >> 16);
            }

            if(this.volumeMultiplier != null) {
               var14 = this.volumeMultiplier.method2334(var1);
               var15 = this.volumeMultiplierAmplitude.method2334(var1);
               var13 = var13 * ((this.method991(var10, var15, this.volumeMultiplier.form) >> 1) + 32768) >> 15;
               var10 = var10 + var9 + (var14 * var8 >> 16);
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.oscillatorVolume[var14] != 0) {
                  var15 = delays[var14] + var11;
                  if(var15 < var1) {
                     samples[var15] += this.method991(phases[var14], var13 * volumeSteps[var14] >> 15, this.pitch.form);
                     phases[var14] += (var12 * pitchSteps[var14] >> 16) + pitchBaseSteps[var14];
                  }
               }
            }
         }

         int var16;
         if(this.release != null) {
            this.release.method2333();
            this.field1501.method2333();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.release.method2334(var1);
               var16 = this.field1501.method2334(var1);
               if(var20) {
                  var12 = (var15 * (this.release.end - this.release.start) >> 8) + this.release.start;
               } else {
                  var12 = (var16 * (this.release.end - this.release.start) >> 8) + this.release.start;
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  samples[var14] = 0;
               }
            }
         }

         if(this.delayTime > 0 && this.delayDecay > 0) {
            var11 = (int)((double)this.delayTime * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               samples[var12] += samples[var12 - var11] * this.delayDecay / 100;
            }
         }

         if(this.filter.pairs[0] > 0 || this.filter.pairs[1] > 0) {
            this.filterEnvelope.method2333();
            var11 = this.filterEnvelope.method2334(var1 + 1);
            var12 = this.filter.method1859(0, (float)var11 / 65536.0F);
            var13 = this.filter.method1859(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)samples[var14 + var12] * (long)SoundEffect3.fowardMultiplier >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)samples[var14 + var12 - 1 - var17] * (long)SoundEffect3.coefficients[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)samples[var14 - 1 - var17] * (long)SoundEffect3.coefficients[1][var17] >> 16);
                  }

                  samples[var14] = var16;
                  var11 = this.filterEnvelope.method2334(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)samples[var14 + var12] * (long)SoundEffect3.fowardMultiplier >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)samples[var14 + var12 - 1 - var18] * (long)SoundEffect3.coefficients[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)samples[var14 - 1 - var18] * (long)SoundEffect3.coefficients[1][var18] >> 16);
                     }

                     samples[var14] = var17;
                     var11 = this.filterEnvelope.method2334(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)samples[var14 + var12 - 1 - var18] * (long)SoundEffect3.coefficients[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)samples[var14 - 1 - var18] * (long)SoundEffect3.coefficients[1][var18] >> 16);
                        }

                        samples[var14] = var17;
                        this.filterEnvelope.method2334(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.filter.method1859(0, (float)var11 / 65536.0F);
                  var13 = this.filter.method1859(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(samples[var11] < -32768) {
               samples[var11] = -32768;
            }

            if(samples[var11] > 32767) {
               samples[var11] = 32767;
            }
         }

         return samples;
      }
   }

   @ObfuscatedName("s")
   final int method991(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?AUDIO_SINE[var1 & 32767] * var2 >> 14:(var3 == 3?(var2 * (var1 & 32767) >> 14) - var2:(var3 == 4?var2 * NOISE[var1 / 2607 & 32767]:0)));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgx;)V"
   )
   final void method998(Packet var1) {
      this.pitch = new AudioEnvelope();
      this.pitch.method2337(var1);
      this.volume = new AudioEnvelope();
      this.volume.method2337(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.pitchModifier = new AudioEnvelope();
         this.pitchModifier.method2337(var1);
         this.pitchModifierAmplitude = new AudioEnvelope();
         this.pitchModifierAmplitude.method2337(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.volumeMultiplier = new AudioEnvelope();
         this.volumeMultiplier.method2337(var1);
         this.volumeMultiplierAmplitude = new AudioEnvelope();
         this.volumeMultiplierAmplitude.method2337(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.release = new AudioEnvelope();
         this.release.method2337(var1);
         this.field1501 = new AudioEnvelope();
         this.field1501.method2337(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method5269();
         if(var4 == 0) {
            break;
         }

         this.oscillatorVolume[var3] = var4;
         this.oscillatorPitch[var3] = var1.method5099();
         this.oscillatorDelays[var3] = var1.method5269();
      }

      this.delayTime = var1.method5269();
      this.delayDecay = var1.method5269();
      this.duration = var1.readUnsignedShort();
      this.offset = var1.readUnsignedShort();
      this.filter = new SoundEffect3();
      this.filterEnvelope = new AudioEnvelope();
      this.filter.method1860(var1, this.filterEnvelope);
   }
}
