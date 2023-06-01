package net.runelite.standalone;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public final class Node2LinkedList {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   CacheableNode sentinel;

   public Node2LinkedList() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("f")
   void method1230() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method1606();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lho;"
   )
   CacheableNode method1244() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method1606();
         return var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lho;)V"
   )
   public void method1226(CacheableNode var1) {
      if(var1.next != null) {
         var1.method1606();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lho;)V"
   )
   public void method1228(CacheableNode var1) {
      if(var1.next != null) {
         var1.method1606();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "()Lho;"
   )
   public CacheableNode method1231() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lho;Lho;)V"
   )
   static void method1229(CacheableNode var0, CacheableNode var1) {
      if(var0.next != null) {
         var0.method1606();
      }

      var0.next = var1;
      var0.previous = var1.previous;
      var0.next.previous = var0;
      var0.previous.next = var0;
   }
}
