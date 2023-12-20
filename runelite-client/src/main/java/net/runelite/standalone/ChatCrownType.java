package net.runelite.standalone;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public enum ChatCrownType implements Enumerated {

    PLAYER(0, -1, false, true),
    YOUTUBER(1, 7, false, true),
    PLAYER_MOD(5, 6, true, false),
    STAFF_MOD(4, 1, true, false),
    SERVER_SUPPORT(6, 14, true, false),
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
