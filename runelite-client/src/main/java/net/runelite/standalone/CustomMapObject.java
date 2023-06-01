package net.runelite.standalone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CustomMapObject {

    public static final boolean ENABLED = false;

    private static final Map<Integer, List<CustomMapObject>>
            REMOVE_MAP = new HashMap<>(),
            SPAWN_MAP = new HashMap<>();

    private int id;
    private int x, y, z;
    private int type, direction;

    private static CustomMapObject mapObject(int id, int x, int y, int z, int type, int direction) {
        CustomMapObject obj = new CustomMapObject();
        obj.id = id;
        obj.x = x;
        obj.y = y;
        obj.z = z;
        obj.type = type;
        obj.direction = direction;
        return obj;
    }

    public static boolean isRemoved(int id, int localX, int localY, int z, int type, int direction) {
        if (ENABLED) {
            int x = class53.baseX + localX;
            int y = class312.baseY + localY;
            int hash = y + (x << 14) + (z << 28);
            List<CustomMapObject> objs = REMOVE_MAP.get(hash);
            if (objs != null) {
                for (CustomMapObject obj : objs) {
                    if (obj.id != id || obj.x != x || obj.y != y || obj.type != type || obj.direction != direction)
                        continue;
                    return true;
                }
            }
        }
        return false;
    }

    public static void applyToScene() {
        if (ENABLED) {
            for (int z = 0; z < 4; z++) {
                for (int localX = 0; localX < 104; localX++) {
                    for (int localY = 0; localY < 104; localY++) {
                        int x = class53.baseX + localX;
                        int y = class312.baseY + localY;
                        int hash = y + (x << 14) + (z << 28);
                        List<CustomMapObject> objs = SPAWN_MAP.get(hash);
                        if (objs != null) {
                            for (CustomMapObject obj : objs) {
                                class253.addMapObject(z, localX, localY, obj.id, obj.direction, obj.type,
                                        class312.sceneManager, client.collisionMaps[z], true);
                            }
                        }
                    }
                }
            }
        }
    }

    private void spawn() {
        toMap(SPAWN_MAP);
    }

    private void remove() {
        toMap(REMOVE_MAP);
    }

    private void toMap(Map<Integer, List<CustomMapObject>> map) {
        final int hash = y + (x << 14) + (z << 28);
        List<CustomMapObject> objs = map.computeIfAbsent(hash, k -> new ArrayList<>());
        objs.add(this);
    }

    private static void spawnRedCarpet(int swX, int swY, int neX, int neY) {
        for(int x = swX; x <= neX; x++) {
            for(int y = swY; y <= neY; y++) {
                if (x == swX) {
                    if (y == swY)
                        mapObject(6812, x, y, 0, 22, 3).spawn();
                    else if (y == neY)
                        mapObject(6812, x, y, 0, 22, 0).spawn();
                    else
                        mapObject(6813, x, y, 0, 22, 3).spawn();
                } else if (x == neX) {
                    if (y == swY)
                        mapObject(6812, x, y, 0, 22, 2).spawn();
                    else if (y == neY)
                        mapObject(6812, x, y, 0, 22, 1).spawn();
                    else
                        mapObject(6813, x, y, 0, 22, 1).spawn();
                } else {
                    if (y == swY)
                        mapObject(6813, x, y, 0, 22, 2).spawn();
                    else if (y == neY)
                        mapObject(6813, x, y, 0, 22, 0).spawn();
                    else
                        mapObject(6814, x, y, 0, 22, 0).spawn();
                }
            }
        }
    }

    private static void newMapObjects() {
        mapObject(307, 3088, 3509, 0, 10, 0).remove(); //cart

        mapObject(1838, 3090, 3508, 0, 5, 2).remove();
        mapObject(1838, 3090, 3512, 0, 5, 2).remove();
        mapObject(362, 3091, 3507, 0, 10, 2).remove();
        mapObject(362, 3091, 3508, 0, 10, 3).remove();
        mapObject(1838, 3091, 3508, 0, 4, 0).remove();
        mapObject(298, 3091, 3510, 0, 10, 1).remove();
        mapObject(1838, 3091, 3512, 0, 4, 0).remove();
        mapObject(362, 3091, 3513, 0, 10, 3).remove();
        mapObject(1258, 3091, 3514, 0, 22, 3).remove();
        mapObject(1844, 3092, 3506, 0, 5, 1).remove();
        mapObject(1844, 3092, 3507, 0, 4, 3).remove();
        mapObject(362, 3092, 3513, 0, 10, 0).remove();
        mapObject(1838, 3092, 3513, 0, 4, 1).remove();
        mapObject(1838, 3092, 3514, 0, 5, 3).remove();
        mapObject(296, 3093, 3507, 0, 10, 2).remove();
        mapObject(300, 3093, 3509, 0, 10, 1).remove();
        mapObject(1016, 3093, 3513, 0, 10, 1).remove();
        mapObject(1258, 3094, 3506, 0, 22, 1).remove();
        mapObject(1263, 3094, 3511, 0, 22, 3).remove();
        mapObject(299, 3094, 3513, 0, 10, 0).remove();
        mapObject(1258, 3094, 3514, 0, 22, 0).remove();
        mapObject(1259, 3095, 3506, 0, 22, 2).remove();
        mapObject(1262, 3095, 3510, 0, 22, 0).remove();
        mapObject(1258, 3095, 3514, 0, 22, 0).remove();
        mapObject(1259, 3096, 3506, 0, 22, 1).remove();
        mapObject(1017, 3096, 3507, 0, 10, 3).remove();
        mapObject(16683, 3096, 3511, 0, 10, 3).remove();
        mapObject(1015, 3096, 3513, 0, 10, 1).remove();
        mapObject(1258, 3097, 3506, 0, 22, 3).remove();
        mapObject(1018, 3097, 3507, 0, 10, 3).remove();
        mapObject(1263, 3097, 3510, 0, 22, 0).remove();
        mapObject(1016, 3097, 3513, 0, 10, 1).remove();
        mapObject(1262, 3097, 3513, 0, 22, 1).remove();
        mapObject(1258, 3098, 3506, 0, 22, 2).remove();
        mapObject(1016, 3098, 3507, 0, 10, 3).remove();
        mapObject(1262, 3098, 3508, 0, 22, 1).remove();
        mapObject(356, 3098, 3513, 0, 10, 3).remove();
        mapObject(1259, 3099, 3506, 0, 22, 1).remove();
        mapObject(1838, 3099, 3506, 0, 5, 1).remove();
        mapObject(356, 3099, 3507, 0, 10, 0).remove();
        mapObject(1838, 3099, 3507, 0, 4, 3).remove();
        mapObject(1262, 3099, 3511, 0, 22, 2).remove();
        mapObject(357, 3099, 3512, 0, 10, 2).remove();
        mapObject(357, 3099, 3513, 0, 10, 3).remove();
        mapObject(1844, 3099, 3513, 0, 4, 1).remove();
        mapObject(1844, 3099, 3514, 0, 5, 3).remove();
        mapObject(1259, 3100, 3506, 0, 22, 2).remove();
        mapObject(358, 3100, 3507, 0, 10, 3).remove();
        mapObject(356, 3100, 3508, 0, 10, 3).remove();
        mapObject(1838, 3100, 3508, 0, 4, 2).remove();
        mapObject(357, 3100, 3512, 0, 10, 1).remove();
        mapObject(1838, 3100, 3512, 0, 4, 2).remove();
        mapObject(358, 3100, 3513, 0, 10, 3).remove();
        mapObject(1259, 3101, 3506, 0, 22, 1).remove();
        mapObject(1259, 3101, 3507, 0, 22, 0).remove();
        mapObject(1838, 3101, 3508, 0, 5, 0).remove();
        mapObject(1521, 3101, 3509, 0, 0, 0).remove();
        mapObject(1524, 3101, 3510, 0, 0, 0).remove();
        mapObject(205, 3101, 3511, 0, 5, 0).remove();
        mapObject(1259, 3101, 3511, 0, 22, 0).remove();
        mapObject(1259, 3101, 3512, 0, 22, 3).remove();
        mapObject(1838, 3101, 3512, 0, 5, 0).remove();
        mapObject(1258, 3101, 3513, 0, 22, 1).remove();

        mapObject(1902, 3092, 3506, 0, 0, 1).remove();
        mapObject(1902, 3092, 3514, 0, 0, 3).remove();
        mapObject(1902, 3099, 3506, 0, 0, 1).remove();
        mapObject(1902, 3099, 3514, 0, 0, 3).remove();
        mapObject(1902, 3101, 3509, 0, 0, 0).spawn();
        mapObject(1902, 3101, 3510, 0, 0, 0).spawn();
        mapObject(8324, 3101, 3510, 0, 0, 0).spawn();
        mapObject(1534, 3092, 3506, 0, 0, 1).spawn();
        mapObject(1534, 3092, 3514, 0, 0, 3).spawn();
        mapObject(1534, 3099, 3506, 0, 0, 1).spawn();
        mapObject(1534, 3099, 3514, 0, 0, 3).spawn();

        mapObject(13187, 3100, 3509, 0,  10, 3).spawn();
//        mapObject(13642, 3091, 3510, 0,  10, 1).spawn();
        spawnRedCarpet(3091, 3509, 3099, 3511);

        mapObject(1823, 3075, 3508, 0, 5, 2).remove();
        mapObject(1259, 3075, 3509, 0, 22, 0).remove();
        mapObject(1258, 3075, 3510, 0, 22, 3).remove();
        mapObject(196, 3076, 3507, 0, 7, 1).remove();
        mapObject(1823, 3076, 3508, 0, 4, 0).remove();
        mapObject(1017, 3076, 3509, 0, 10, 0).remove();
        mapObject(1016, 3076, 3510, 0, 10, 0).remove();
        mapObject(1015, 3076, 3511, 0, 10, 0).remove();
        mapObject(1016, 3076, 3512, 0, 10, 0).remove();
        mapObject(196, 3076, 3513, 0, 7, 2).remove();
        mapObject(381, 3077, 3507, 0, 10, 3).remove();
        mapObject(917, 3077, 3511, 0, 22, 3).remove();
        mapObject(917, 3077, 3512, 0, 22, 0).remove();
        mapObject(17390, 3077, 3512, 0, 10, 1).remove();
        mapObject(1018, 3077, 3513, 0, 10, 1).remove();
        mapObject(1823, 3078, 3507, 0, 4, 3).remove();
        mapObject(595, 3078, 3510, 0, 10, 0).remove();
        mapObject(918, 3078, 3511, 0, 22, 2).remove();
        mapObject(918, 3078, 3512, 0, 22, 0).remove();
        mapObject(1017, 3078, 3513, 0, 10, 1).remove();
        mapObject(205, 3079, 3506, 0, 5, 1).remove();
        mapObject(381, 3079, 3507, 0, 10, 3).remove();
        mapObject(918, 3079, 3511, 0, 22, 2).remove();
        mapObject(918, 3079, 3512, 0, 22, 0).remove();
        mapObject(1018, 3079, 3513, 0, 10, 1).remove();
        mapObject(1259, 3079, 3514, 0, 22, 3).remove();
        mapObject(356, 3080, 3510, 0, 10, 0).remove();
        mapObject(918, 3080, 3511, 0, 22, 2).remove();
        mapObject(918, 3080, 3512, 0, 22, 0).remove();
        mapObject(1016, 3080, 3513, 0, 10, 1).remove();
        mapObject(1258, 3080, 3514, 0, 22, 0).remove();
        mapObject(196, 3081, 3507, 0, 4, 3).remove();
        mapObject(595, 3081, 3510, 0, 10, 0).remove();
        mapObject(918, 3081, 3511, 0, 22, 2).remove();
        mapObject(918, 3081, 3512, 0, 22, 0).remove();
        mapObject(887, 3081, 3513, 0, 4, 1).remove();
        mapObject(1259, 3081, 3514, 0, 22, 0).remove();
        mapObject(1823, 3082, 3507, 0, 4, 3).remove();
        mapObject(918, 3082, 3511, 0, 22, 2).remove();
        mapObject(918, 3082, 3512, 0, 22, 0).remove();
        mapObject(196, 3082, 3513, 0, 4, 1).remove();
        mapObject(1258, 3083, 3506, 0, 22, 1).remove();
        mapObject(374, 3083, 3507, 0, 10, 2).remove();
        mapObject(917, 3083, 3511, 0, 22, 2).remove();
        mapObject(917, 3083, 3512, 0, 22, 1).remove();
        mapObject(16683, 3083, 3513, 0, 10, 2).remove();
        mapObject(196, 3084, 3507, 0, 7, 0).remove();
        mapObject(1823, 3084, 3508, 0, 4, 2).remove();
        mapObject(358, 3084, 3509, 0, 10, 2).remove();
        mapObject(887, 3084, 3509, 0, 4, 2).remove();
        mapObject(358, 3084, 3510, 0, 10, 2).remove();
        mapObject(1023, 3084, 3510, 0, 4, 2).remove();
        mapObject(1023, 3084, 3511, 0, 4, 2).remove();
        mapObject(357, 3084, 3512, 0, 10, 1).remove();
        mapObject(1023, 3084, 3512, 0, 4, 2).remove();
        mapObject(196, 3084, 3513, 0, 7, 3).remove();
        mapObject(1823, 3085, 3508, 0, 5, 0).remove();
        mapObject(1259, 3085, 3510, 0, 22, 0).remove();
        mapObject(1902, 3085, 3510, 0, 0, 0).remove();
        mapObject(1534, 3085, 3510, 0, 0, 0).spawn();

        spawnRedCarpet(3077, 3508, 3083, 3512);

        // Bank
        mapObject(1088,  3092, 3496, 0, 11, 0).remove();
        mapObject(1088,  3090, 3496, 0, 11, 3).remove();
        mapObject(29716,  3090, 3494, 0, 11, 2).remove();
        mapObject(598,  3091, 3495, 0, 10, 3).remove();
        mapObject(590,  3095, 3498, 0, 10, 2).remove();
        mapObject(1088,  3095, 3499, 0, 10, 0).remove();
        mapObject(10059,  3092, 3493, 0, 1, 0).spawn();
        mapObject(10059,  3091, 3493, 0, 9, 0).spawn();
        mapObject(10060,  3092, 3494, 0, 0, 0).spawn();
        mapObject(10060,  3092, 3495, 0, 0, 0).spawn();
        mapObject(10060,  3092, 3496, 0, 0, 0).spawn();
        mapObject(10059,  3092, 3497, 0, 1, 3).spawn();
        mapObject(10059,  3091, 3497, 0, 9, 3).spawn();

        int x = 3073;
        int y = 3498;
        mapObject(14097,  x, y, 0, 22, 0).spawn();
        mapObject(14099,  x - 1, y + 1, 0, 22, 2).spawn();
        mapObject(14098,  x - 1, y, 0, 22, 2).spawn();
        mapObject(14099,  x - 1, y - 1, 0, 22, 1).spawn();
        mapObject(14098,  x, y - 1, 0, 22, 1).spawn();
        mapObject(14099,  x + 1, y - 1, 0, 22, 0).spawn();
        mapObject(14098,  x + 1, y, 0, 22, 0).spawn();
        mapObject(14099,  x + 1, y + 1, 0, 22, 3).spawn();
        mapObject(14098,  x, y + 1, 0, 22, 3).spawn();

        /*mapObject(1902,  3095, 3493, 0, 2, 0).remove();
        mapObject(1902,  3095, 3492, 0, 2, 3).remove();
        mapObject(1902,  3096, 3492, 0, 0, 2).remove();
        mapObject(1902,  3097, 3493, 0, 2, 0).remove();
        mapObject(1902,  3095, 3490, 0, 2, 3).remove();
        mapObject(1902,  3095, 3488, 0, 0, 0).remove();
        mapObject(1902,  3096, 3490, 0, 0, 3).remove();
        mapObject(1902,  3096, 3492, 0, 0, 3).remove();
        mapObject(6943,  3095, 3489, 0, 10, 3).remove();
        mapObject(6943,  3095, 3491, 0, 10, 3).remove();
        mapObject(6943,  3096, 3493, 0, 10, 0).remove();
        mapObject(6943,  3098, 3493, 0, 10, 0).remove();*/
    }

    private static void oldZenyteMapObjects() {
        mapObject(307, 3088, 3509, 0, 10, 0).remove(); //cart

        mapObject(1838, 3090, 3508, 0, 5, 2).remove();
        mapObject(1838, 3090, 3512, 0, 5, 2).remove();
        mapObject(362, 3091, 3507, 0, 10, 2).remove();
        mapObject(362, 3091, 3508, 0, 10, 3).remove();
        mapObject(1838, 3091, 3508, 0, 4, 0).remove();
        mapObject(298, 3091, 3510, 0, 10, 1).remove();
        mapObject(1838, 3091, 3512, 0, 4, 0).remove();
        mapObject(362, 3091, 3513, 0, 10, 3).remove();
        mapObject(1258, 3091, 3514, 0, 22, 3).remove();
        mapObject(1844, 3092, 3506, 0, 5, 1).remove();
        mapObject(1844, 3092, 3507, 0, 4, 3).remove();
        mapObject(362, 3092, 3513, 0, 10, 0).remove();
        mapObject(1838, 3092, 3513, 0, 4, 1).remove();
        mapObject(1838, 3092, 3514, 0, 5, 3).remove();
        mapObject(296, 3093, 3507, 0, 10, 2).remove();
        mapObject(300, 3093, 3509, 0, 10, 1).remove();
        mapObject(1016, 3093, 3513, 0, 10, 1).remove();
        mapObject(1258, 3094, 3506, 0, 22, 1).remove();
        mapObject(1263, 3094, 3511, 0, 22, 3).remove();
        mapObject(299, 3094, 3513, 0, 10, 0).remove();
        mapObject(1258, 3094, 3514, 0, 22, 0).remove();
        mapObject(1259, 3095, 3506, 0, 22, 2).remove();
        mapObject(1262, 3095, 3510, 0, 22, 0).remove();
        mapObject(1258, 3095, 3514, 0, 22, 0).remove();
        mapObject(1259, 3096, 3506, 0, 22, 1).remove();
        mapObject(1017, 3096, 3507, 0, 10, 3).remove();
        mapObject(16683, 3096, 3511, 0, 10, 3).remove();
        mapObject(1015, 3096, 3513, 0, 10, 1).remove();
        mapObject(1258, 3097, 3506, 0, 22, 3).remove();
        mapObject(1018, 3097, 3507, 0, 10, 3).remove();
        mapObject(1263, 3097, 3510, 0, 22, 0).remove();
        mapObject(1016, 3097, 3513, 0, 10, 1).remove();
        mapObject(1262, 3097, 3513, 0, 22, 1).remove();
        mapObject(1258, 3098, 3506, 0, 22, 2).remove();
        mapObject(1016, 3098, 3507, 0, 10, 3).remove();
        mapObject(1262, 3098, 3508, 0, 22, 1).remove();
        mapObject(356, 3098, 3513, 0, 10, 3).remove();
        mapObject(1259, 3099, 3506, 0, 22, 1).remove();
        mapObject(1838, 3099, 3506, 0, 5, 1).remove();
        mapObject(356, 3099, 3507, 0, 10, 0).remove();
        mapObject(1838, 3099, 3507, 0, 4, 3).remove();
        mapObject(1262, 3099, 3511, 0, 22, 2).remove();
        mapObject(357, 3099, 3512, 0, 10, 2).remove();
        mapObject(357, 3099, 3513, 0, 10, 3).remove();
        mapObject(1844, 3099, 3513, 0, 4, 1).remove();
        mapObject(1844, 3099, 3514, 0, 5, 3).remove();
        mapObject(1259, 3100, 3506, 0, 22, 2).remove();
        mapObject(358, 3100, 3507, 0, 10, 3).remove();
        mapObject(356, 3100, 3508, 0, 10, 3).remove();
        mapObject(1838, 3100, 3508, 0, 4, 2).remove();
        mapObject(357, 3100, 3512, 0, 10, 1).remove();
        mapObject(1838, 3100, 3512, 0, 4, 2).remove();
        mapObject(358, 3100, 3513, 0, 10, 3).remove();
        mapObject(1259, 3101, 3506, 0, 22, 1).remove();
        mapObject(1259, 3101, 3507, 0, 22, 0).remove();
        mapObject(1838, 3101, 3508, 0, 5, 0).remove();
        mapObject(1521, 3101, 3509, 0, 0, 0).remove();
        mapObject(1524, 3101, 3510, 0, 0, 0).remove();
        mapObject(205, 3101, 3511, 0, 5, 0).remove();
        mapObject(1259, 3101, 3511, 0, 22, 0).remove();
        mapObject(1259, 3101, 3512, 0, 22, 3).remove();
        mapObject(1838, 3101, 3512, 0, 5, 0).remove();
        mapObject(1258, 3101, 3513, 0, 22, 1).remove();

        mapObject(1902, 3092, 3506, 0, 0, 1).remove();
        mapObject(1902, 3092, 3514, 0, 0, 3).remove();
        mapObject(1902, 3099, 3506, 0, 0, 1).remove();
        mapObject(1902, 3099, 3514, 0, 0, 3).remove();
        mapObject(1902, 3101, 3509, 0, 0, 0).spawn();
        mapObject(1902, 3101, 3510, 0, 0, 0).spawn();
        mapObject(8324, 3101, 3510, 0, 0, 0).spawn();
        mapObject(1534, 3092, 3506, 0, 0, 1).spawn();
        mapObject(1534, 3092, 3514, 0, 0, 3).spawn();
        mapObject(1534, 3099, 3506, 0, 0, 1).spawn();
        mapObject(1534, 3099, 3514, 0, 0, 3).spawn();

        mapObject(13187, 3100, 3509, 0,  10, 3).spawn();
//        mapObject(13642, 3091, 3510, 0,  10, 1).spawn();
        spawnRedCarpet(3091, 3509, 3099, 3511);

        mapObject(1823, 3075, 3508, 0, 5, 2).remove();
        mapObject(1259, 3075, 3509, 0, 22, 0).remove();
        mapObject(1258, 3075, 3510, 0, 22, 3).remove();
        mapObject(196, 3076, 3507, 0, 7, 1).remove();
        mapObject(1823, 3076, 3508, 0, 4, 0).remove();
        mapObject(1017, 3076, 3509, 0, 10, 0).remove();
        mapObject(1016, 3076, 3510, 0, 10, 0).remove();
        mapObject(1015, 3076, 3511, 0, 10, 0).remove();
        mapObject(1016, 3076, 3512, 0, 10, 0).remove();
        mapObject(196, 3076, 3513, 0, 7, 2).remove();
        mapObject(381, 3077, 3507, 0, 10, 3).remove();
        mapObject(917, 3077, 3511, 0, 22, 3).remove();
        mapObject(917, 3077, 3512, 0, 22, 0).remove();
        mapObject(17390, 3077, 3512, 0, 10, 1).remove();
        mapObject(1018, 3077, 3513, 0, 10, 1).remove();
        mapObject(1823, 3078, 3507, 0, 4, 3).remove();
        mapObject(595, 3078, 3510, 0, 10, 0).remove();
        mapObject(918, 3078, 3511, 0, 22, 2).remove();
        mapObject(918, 3078, 3512, 0, 22, 0).remove();
        mapObject(1017, 3078, 3513, 0, 10, 1).remove();
        mapObject(205, 3079, 3506, 0, 5, 1).remove();
        mapObject(381, 3079, 3507, 0, 10, 3).remove();
        mapObject(918, 3079, 3511, 0, 22, 2).remove();
        mapObject(918, 3079, 3512, 0, 22, 0).remove();
        mapObject(1018, 3079, 3513, 0, 10, 1).remove();
        mapObject(1259, 3079, 3514, 0, 22, 3).remove();
        mapObject(356, 3080, 3510, 0, 10, 0).remove();
        mapObject(918, 3080, 3511, 0, 22, 2).remove();
        mapObject(918, 3080, 3512, 0, 22, 0).remove();
        mapObject(1016, 3080, 3513, 0, 10, 1).remove();
        mapObject(1258, 3080, 3514, 0, 22, 0).remove();
        mapObject(196, 3081, 3507, 0, 4, 3).remove();
        mapObject(595, 3081, 3510, 0, 10, 0).remove();
        mapObject(918, 3081, 3511, 0, 22, 2).remove();
        mapObject(918, 3081, 3512, 0, 22, 0).remove();
        mapObject(887, 3081, 3513, 0, 4, 1).remove();
        mapObject(1259, 3081, 3514, 0, 22, 0).remove();
        mapObject(1823, 3082, 3507, 0, 4, 3).remove();
        mapObject(918, 3082, 3511, 0, 22, 2).remove();
        mapObject(918, 3082, 3512, 0, 22, 0).remove();
        mapObject(196, 3082, 3513, 0, 4, 1).remove();
        mapObject(1258, 3083, 3506, 0, 22, 1).remove();
        mapObject(374, 3083, 3507, 0, 10, 2).remove();
        mapObject(917, 3083, 3511, 0, 22, 2).remove();
        mapObject(917, 3083, 3512, 0, 22, 1).remove();
        mapObject(16683, 3083, 3513, 0, 10, 2).remove();
        mapObject(196, 3084, 3507, 0, 7, 0).remove();
        mapObject(1823, 3084, 3508, 0, 4, 2).remove();
        mapObject(358, 3084, 3509, 0, 10, 2).remove();
        mapObject(887, 3084, 3509, 0, 4, 2).remove();
        mapObject(358, 3084, 3510, 0, 10, 2).remove();
        mapObject(1023, 3084, 3510, 0, 4, 2).remove();
        mapObject(1023, 3084, 3511, 0, 4, 2).remove();
        mapObject(357, 3084, 3512, 0, 10, 1).remove();
        mapObject(1023, 3084, 3512, 0, 4, 2).remove();
        mapObject(196, 3084, 3513, 0, 7, 3).remove();
        mapObject(1823, 3085, 3508, 0, 5, 0).remove();
        mapObject(1259, 3085, 3510, 0, 22, 0).remove();
        mapObject(1902, 3085, 3510, 0, 0, 0).remove();
        mapObject(1534, 3085, 3510, 0, 0, 0).spawn();

        spawnRedCarpet(3077, 3508, 3083, 3512);

        // Bank
        mapObject(1088,  3092, 3496, 0, 11, 0).remove();
        mapObject(1088,  3090, 3496, 0, 11, 3).remove();
        mapObject(29716,  3090, 3494, 0, 11, 2).remove();
        mapObject(598,  3091, 3495, 0, 10, 3).remove();
        mapObject(590,  3095, 3498, 0, 10, 2).remove();
        mapObject(1088,  3095, 3499, 0, 10, 0).remove();
        mapObject(10059,  3092, 3493, 0, 1, 0).spawn();
        mapObject(10059,  3091, 3493, 0, 9, 0).spawn();
        mapObject(10060,  3092, 3494, 0, 0, 0).spawn();
        mapObject(10060,  3092, 3495, 0, 0, 0).spawn();
        mapObject(10060,  3092, 3496, 0, 0, 0).spawn();
        mapObject(10059,  3092, 3497, 0, 1, 3).spawn();
        mapObject(10059,  3091, 3497, 0, 9, 3).spawn();

        int x = 3073;
        int y = 3498;
        mapObject(14097,  x, y, 0, 22, 0).spawn();
        mapObject(14099,  x - 1, y + 1, 0, 22, 2).spawn();
        mapObject(14098,  x - 1, y, 0, 22, 2).spawn();
        mapObject(14099,  x - 1, y - 1, 0, 22, 1).spawn();
        mapObject(14098,  x, y - 1, 0, 22, 1).spawn();
        mapObject(14099,  x + 1, y - 1, 0, 22, 0).spawn();
        mapObject(14098,  x + 1, y, 0, 22, 0).spawn();
        mapObject(14099,  x + 1, y + 1, 0, 22, 3).spawn();
        mapObject(14098,  x, y + 1, 0, 22, 3).spawn();

        /*mapObject(1902,  3095, 3493, 0, 2, 0).remove();
        mapObject(1902,  3095, 3492, 0, 2, 3).remove();
        mapObject(1902,  3096, 3492, 0, 0, 2).remove();
        mapObject(1902,  3097, 3493, 0, 2, 0).remove();
        mapObject(1902,  3095, 3490, 0, 2, 3).remove();
        mapObject(1902,  3095, 3488, 0, 0, 0).remove();
        mapObject(1902,  3096, 3490, 0, 0, 3).remove();
        mapObject(1902,  3096, 3492, 0, 0, 3).remove();
        mapObject(6943,  3095, 3489, 0, 10, 3).remove();
        mapObject(6943,  3095, 3491, 0, 10, 3).remove();
        mapObject(6943,  3096, 3493, 0, 10, 0).remove();
        mapObject(6943,  3098, 3493, 0, 10, 0).remove();*/
    }

    static {
        newMapObjects();
    }
}
