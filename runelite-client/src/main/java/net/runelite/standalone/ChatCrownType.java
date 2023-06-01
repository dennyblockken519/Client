package net.runelite.standalone;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public enum ChatCrownType implements Enumerated {

    NONE(0, -1, false, true),
    IRONMAN(1, 2, false, true),
    ULTIMATE_IRONMAN(2, 3, false, true),
    HARDCORE_IRONMAN(3, 4, false, true),
    PLAYER_MOD(4, 0, true, false),
    STAFF_MOD(5, 1, true, false),
    SERVER_SUPPORT(6, 5, true, false),
    SERVER_OWNER(7, 6, true, false),
    GAME_DEVELOPER(8, 7, true, false);

    @ObfuscatedName("e")
    static int[] field3209;
    @ObfuscatedName("q")
    public final boolean staff;
    @ObfuscatedName("m")
    public final int icon;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = 1798871115
    )
    final int id;
    @ObfuscatedName("b")
    public final boolean ignorable;

    ChatCrownType(int id, int icon, boolean staff, boolean ignorable) {
        this.id = id;
        this.icon = icon;
        this.staff = staff;
        this.ignorable = ignorable;
    }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            signature = "(I)I",
            garbageValue = "-303219076"
    )
    public int vmethod6373() {
        return this.id;
    }
}
