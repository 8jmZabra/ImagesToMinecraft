package me.zabra.ImageViewer;

import org.bukkit.DyeColor;
import org.bukkit.Material;

import java.awt.*;

import static me.zabra.ImageViewer.blocksHex.blockColours;
import static me.zabra.ImageViewer.blocksHex.materials;

public class closestColour {
    // DEFAULT COLOURS
    private static Color black = Color.decode("#1D1D21");
    private static Color red = Color.decode("#B02E26");
    private static Color green = Color.decode("#5E7C16");
    private static Color brown = Color.decode("#835432");
    private static Color blue = Color.decode("#3C44AA");
    private static Color purple = Color.decode("#8932B8");
    private static Color cyan = Color.decode("#169C9C");
    private static Color light_gray = Color.decode("#9D9D97");
    private static Color gray = Color.decode("#474F52");
    private static Color pink = Color.decode("#F38BAA");
    private static Color lime = Color.decode("#80C71F");
    private static Color yellow = Color.decode("#FED83D");
    private static Color light_blue = Color.decode("#3AB3DA");
    private static Color magenta = Color.decode("#C74EDB");
    private static Color orange = Color.decode("#F9801D");
    private static Color white = Color.decode("#F9FFFE");

    private static Material black_wool = Material.BLACK_WOOL;
    private static Material red_wool = Material.RED_WOOL;
    private static Material green_wool = Material.GREEN_WOOL;
    private static Material brown_wool = Material.BROWN_WOOL;
    private static Material blue_wool = Material.BLUE_WOOL;
    private static Material purple_wool = Material.PURPLE_WOOL;
    private static Material cyan_wool = Material.CYAN_WOOL;
    private static Material light_gray_wool = Material.LIGHT_GRAY_WOOL;
    private static Material gray_wool = Material.GRAY_WOOL;
    private static Material pink_wool = Material.PINK_WOOL;
    private static Material lime_wool = Material.LIME_WOOL;
    private static Material yellow_wool = Material.YELLOW_WOOL;
    private static Material light_blue_wool = Material.LIGHT_BLUE_WOOL;
    private static Material magenta_wool = Material.MAGENTA_WOOL;
    private static Material orange_wool = Material.ORANGE_WOOL;
    private static Material white_wool = Material.WHITE_WOOL;

    private static Color[] colours = {black, red, green, brown, blue, purple, cyan, light_gray, gray, pink, lime, yellow, light_blue, magenta, orange, white};

    // EXTRA COLOURS FOR BLOCK
    //private static Color[] blockColours = {Color.decode("#696359"), Color.decode("#A95C33"), Color.decode("#838383"), Color.decode("#414141"), Color.decode("#75DDD8"), Color.decode("#545454"), Color.decode("#CFCEC9"), Color.decode("#C4B37B"), Color.decode("#CFC29D"), Color.decode("#8AF"), Color.decode("#191B20"), Color.decode("#441E20"), Color.decode("#19191E"), Color.decode("#251710"), Color.decode("#15151A"), Color.decode("#2D2F8F"), Color.decode("#4649A7"), Color.decode("#2F418B"), Color.decode("#74A8FD"), Color.decode("#2C2E8C"), Color.decode("#4A3C5B"), Color.decode("#35399D"), Color.decode("#6C583A"), Color.decode("#CF5B9F"), Color.decode("#936457"), Color.decode("#603C20"), Color.decode("#7E5536"), Color.decode("#786A56"), Color.decode("#8E6B53"), Color.decode("#6A4224"), Color.decode("#4D3324"), Color.decode("#724829"), Color.decode("#A51AA2"), Color.decode("#8E4DD"), Color.decode("#E8E4DC"), Color.decode("#A2531C"), Color.decode("#D8D09B"), Color.decode("#777777"), Color.decode("#866886"), Color.decode("#603C60"), Color.decode("#9FA4B1"), Color.decode("#131313"), Color.decode("#737373"), Color.decode("#77563B"), Color.decode("#7B7B7B"), Color.decode("#9C9796"), Color.decode("#777777"), Color.decode("#A8561E"), Color.decode("#DCD4A2"), Color.decode("#157788"), Color.decode("#25949D"), Color.decode("#34777D"), Color.decode("#147987"), Color.decode("#575B5B"), Color.decode("#158A91"), Color.decode("#342917"), Color.decode("#3D2812"), Color.decode("#4B3217"), Color.decode("#3C584B"), Color.decode("#7C7672"), Color.decode("#847C77"), Color.decode("#847C78"), Color.decode("#867E7A"), Color.decode("#827B78"), Color.decode("#62DBD6"), Color.decode("#818C8F"), Color.decode("#B4B4B7"), Color.decode("#866043"), Color.decode("#D910"), Color.decode("#51D975"), Color.decode("#6E8174"), Color.decode("#DDE0A5"), Color.decode("#E2E7AB"), Color.decode("#734C2D"), Color.decode("#A4232F"), Color.decode("#907646"), Color.decode("#F9EC4F"), Color.decode("#8F8C7D"), Color.decode("#997263"), Color.decode("#7F7C7B"), Color.decode("#373A3E"), Color.decode("#4D5155"), Color.decode("#535A5E"), Color.decode("#373B3E"), Color.decode("#3A2A24"), Color.decode("#3F4448"), Color.decode("#495B24"), Color.decode("#61772D"), Color.decode("#758E43"), Color.decode("#4F6520"), Color.decode("#4C532A"), Color.decode("#556E1C"), Color.decode("#D8C842"), Color.decode("#DBDBDB"), Color.decode("#88827F"), Color.decode("#76442D"), Color.decode("#B9851C"), Color.decode("#57441B"), Color.decode("#9A6E4D"), Color.decode("#27438A"), Color.decode("#667087"), Color.decode("#2489C7"), Color.decode("#4AB5D5"), Color.decode("#5FA5D1"), Color.decode("#31A4D4"), Color.decode("#716D8A"), Color.decode("#3AAFD9"), Color.decode("#7D7D73"), Color.decode("#9B9B94"), Color.decode("#90A6A8"), Color.decode("#7C7C73"), Color.decode("#876B62"), Color.decode("#8E8E87"), Color.decode("#5EA918"), Color.decode("#7DBD2A"), Color.decode("#A3C637"), Color.decode("#64AD17"), Color.decode("#687635"), Color.decode("#70B91A"), Color.decode("#A9309F"), Color.decode("#C154B9"), Color.decode("#D064C0"), Color.decode("#AE36A4"), Color.decode("#96586D"), Color.decode("#BE45B4"), Color.decode("#687968"), Color.decode("#73776A"), Color.decode("#D0CCC2"), Color.decode("#6F3635"), Color.decode("#2D171B"), Color.decode("#7D5550"), Color.decode("#7567"), Color.decode("#654433"), Color.decode("#665132"), Color.decode("#9D804F"), Color.decode("#14121E"), Color.decode("#E06111"), Color.decode("#E38420"), Color.decode("#9B935C"), Color.decode("#EA6A9"), Color.decode("#A25426"), Color.decode("#F17614"), Color.decode("#A5C3F5"), Color.decode("#D6658F"), Color.decode("#E599B5"), Color.decode("#EB9BB6"), Color.decode("#E67A9E"), Color.decode("#A24E4F"), Color.decode("#EE8DAC"), Color.decode("#858587"), Color.decode("#B7B7BA"), Color.decode("#9F7362"), Color.decode("#64A08F"), Color.decode("#64209C"), Color.decode("#8438B2"), Color.decode("#6E3098"), Color.decode("#67209C"), Color.decode("#764656"), Color.decode("#7A2AAD"), Color.decode("#A67AA6"), Color.decode("#AA7EAA"), Color.decode("#E8E4DC"), Color.decode("#AB1C9"), Color.decode("#462B1B"), Color.decode("#856B6B"), Color.decode("#8E2121"), Color.decode("#A83633"), Color.decode("#B63C35"), Color.decode("#B72624"), Color.decode("#4447"), Color.decode("#A95821"), Color.decode("#A6551E"), Color.decode("#8C1F1E"), Color.decode("#8F3D2F"), Color.decode("#A12723"), Color.decode("#979393"), Color.decode("#DBD3A0"), Color.decode("#D9D29D"), Color.decode("#F0FBFB"), Color.decode("#554034"), Color.decode("#C3C455"), Color.decode("#2E1DC"), Color.decode("#684E2F"), Color.decode("#644C31"), Color.decode("#7D7D7D"), Color.decode("#7A7A7A"), Color.decode("#AF5D3C"), Color.decode("#C5B076"), Color.decode("#614C32"), Color.decode("#AB8555"), Color.decode("#B19056"), Color.decode("#745A34"), Color.decode("#594A5A"), Color.decode("#975D43"), Color.decode("#3157CF"), Color.decode("#A09F3F"), Color.decode("#CFD5D6"), Color.decode("#E2E3E4"), Color.decode("#BCD4CB"), Color.decode("#D8DDDD"), Color.decode("#D2B2A1"), Color.decode("#EAECED"), Color.decode("#F1AF15"), Color.decode("#E9C737"), Color.decode("#EAC059"), Color.decode("#F8BD1D"), Color.decode("#BA8523"), Color.decode("#F9C628")};
    //private static Material[] materials = {Material.ACACIA_LOG, Material.ACACIA_PLANKS, Material.ANDESITE, Material.ANVIL, Material.BEACON, Material.BEDROCK, Material.BIRCH_LOG, Material.BIRCH_PLANKS, Material.BIRCH_TRAPDOOR, Material.BLACK_CONCRETE, Material.BLACK_CONCRETE_POWDER, Material.BLACK_GLAZED_TERRACOTTA, Material.BLACK_SHULKER_BOX, Material.BLACK_TERRACOTTA, Material.BLACK_WOOL, Material.BLUE_CONCRETE, Material.BLUE_CONCRETE_POWDER, Material.BLUE_GLAZED_TERRACOTTA, Material.BLUE_ICE, Material.BLUE_SHULKER_BOX, Material.BLUE_TERRACOTTA, Material.BLUE_WOOL, Material.BOOKSHELF, Material.BRAIN_CORAL_BLOCK, Material.BRICKS, Material.BROWN_CONCRETE, Material.BROWN_CONCRETE_POWDER, Material.BROWN_GLAZED_TERRACOTTA, Material.BROWN_MUSHROOM_BLOCK, Material.BROWN_SHULKER_BOX, Material.BROWN_TERRACOTTA, Material.BROWN_WOOL, Material.BUBBLE_CORAL_BLOCK, Material.CARVED_PUMPKIN, Material.CHISELED_QUARTZ_BLOCK, Material.CHISELED_RED_SANDSTONE, Material.CHISELED_SANDSTONE, Material.CHISELED_STONE_BRICKS, Material.CHORUS_FLOWER, Material.CHORUS_PLANT, Material.CLAY, Material.COAL_BLOCK, Material.COAL_ORE, Material.COARSE_DIRT, Material.COBBLESTONE, Material.COMPARATOR, Material.CRACKED_STONE_BRICKS, Material.CUT_RED_SANDSTONE, Material.CUT_SANDSTONE, Material.CYAN_CONCRETE, Material.CYAN_CONCRETE_POWDER, Material.CYAN_GLAZED_TERRACOTTA, Material.CYAN_SHULKER_BOX, Material.CYAN_TERRACOTTA, Material.CYAN_WOOL, Material.DARK_OAK_LOG, Material.DARK_OAK_PLANKS, Material.DARK_OAK_TRAPDOOR, Material.DARK_PRISMARINE, Material.DEAD_BRAIN_CORAL_BLOCK, Material.DEAD_BUBBLE_CORAL_BLOCK, Material.DEAD_FIRE_CORAL_BLOCK, Material.DEAD_HORN_CORAL_BLOCK, Material.DEAD_TUBE_CORAL_BLOCK, Material.DIAMOND_BLOCK, Material.DIAMOND_ORE, Material.DIORITE, Material.DIRT, Material.DRAGON_EGG, Material.EMERALD_BLOCK, Material.EMERALD_ORE, Material.END_STONE, Material.END_STONE_BRICKS, Material.FARMLAND, Material.FIRE_CORAL_BLOCK, Material.GLOWSTONE, Material.GOLD_BLOCK, Material.GOLD_ORE, Material.GRANITE, Material.GRAVEL, Material.GRAY_CONCRETE, Material.GRAY_CONCRETE_POWDER, Material.GRAY_GLAZED_TERRACOTTA, Material.GRAY_SHULKER_BOX, Material.GRAY_TERRACOTTA, Material.GRAY_WOOL, Material.GREEN_CONCRETE, Material.GREEN_CONCRETE_POWDER, Material.GREEN_GLAZED_TERRACOTTA, Material.GREEN_SHULKER_BOX, Material.GREEN_TERRACOTTA, Material.GREEN_WOOL, Material.HORN_CORAL_BLOCK, Material.IRON_BLOCK, Material.IRON_ORE, Material.ITEM_FRAME, Material.JACK_O_LANTERN, Material.JUNGLE_LOG, Material.JUNGLE_PLANKS, Material.LAPIS_BLOCK, Material.LAPIS_ORE, Material.LIGHT_BLUE_CONCRETE, Material.LIGHT_BLUE_CONCRETE_POWDER, Material.LIGHT_BLUE_GLAZED_TERRACOTTA, Material.LIGHT_BLUE_SHULKER_BOX, Material.LIGHT_BLUE_TERRACOTTA, Material.LIGHT_BLUE_WOOL, Material.LIGHT_GRAY_CONCRETE, Material.LIGHT_GRAY_CONCRETE_POWDER, Material.LIGHT_GRAY_GLAZED_TERRACOTTA, Material.LIGHT_GRAY_SHULKER_BOX, Material.LIGHT_GRAY_TERRACOTTA, Material.LIGHT_GRAY_WOOL, Material.LIME_CONCRETE, Material.LIME_CONCRETE_POWDER, Material.LIME_GLAZED_TERRACOTTA, Material.LIME_SHULKER_BOX, Material.LIME_TERRACOTTA, Material.LIME_WOOL, Material.MAGENTA_CONCRETE, Material.MAGENTA_CONCRETE_POWDER, Material.MAGENTA_GLAZED_TERRACOTTA, Material.MAGENTA_SHULKER_BOX, Material.MAGENTA_TERRACOTTA, Material.MAGENTA_WOOL, Material.MOSSY_COBBLESTONE, Material.MOSSY_STONE_BRICKS, Material.MUSHROOM_STEM, Material.NETHERRACK, Material.NETHER_BRICKS, Material.NETHER_QUARTZ_ORE, Material.NETHER_WART_BLOCK, Material.NOTE_BLOCK, Material.OAK_LOG, Material.OAK_PLANKS, Material.OBSIDIAN, Material.ORANGE_CONCRETE, Material.ORANGE_CONCRETE_POWDER, Material.ORANGE_GLAZED_TERRACOTTA, Material.ORANGE_SHULKER_BOX, Material.ORANGE_TERRACOTTA, Material.ORANGE_WOOL, Material.PACKED_ICE, Material.PINK_CONCRETE, Material.PINK_CONCRETE_POWDER, Material.PINK_GLAZED_TERRACOTTA, Material.PINK_SHULKER_BOX, Material.PINK_TERRACOTTA, Material.PINK_WOOL, Material.POLISHED_ANDESITE, Material.POLISHED_DIORITE, Material.POLISHED_GRANITE, Material.PRISMARINE_BRICKS, Material.PURPLE_CONCRETE, Material.PURPLE_CONCRETE_POWDER, Material.PURPLE_GLAZED_TERRACOTTA, Material.PURPLE_SHULKER_BOX, Material.PURPLE_TERRACOTTA, Material.PURPLE_WOOL, Material.PURPUR_BLOCK, Material.PURPUR_PILLAR, Material.QUARTZ_PILLAR, Material.REDSTONE_BLOCK, Material.REDSTONE_LAMP, Material.REDSTONE_ORE, Material.RED_CONCRETE, Material.RED_CONCRETE_POWDER, Material.RED_GLAZED_TERRACOTTA, Material.RED_MUSHROOM_BLOCK, Material.RED_NETHER_BRICKS, Material.RED_SAND, Material.RED_SANDSTONE, Material.RED_SHULKER_BOX, Material.RED_TERRACOTTA, Material.RED_WOOL, Material.REPEATER, Material.SAND, Material.SANDSTONE, Material.SNOW, Material.SOUL_SAND, Material.SPONGE, Material.SPRUCE_LOG, Material.SPRUCE_PLANKS, Material.SPRUCE_TRAPDOOR, Material.STONE, Material.STONE_BRICKS, Material.STRIPPED_ACACIA_LOG, Material.STRIPPED_BIRCH_LOG, Material.STRIPPED_DARK_OAK_LOG, Material.STRIPPED_JUNGLE_LOG, Material.STRIPPED_OAK_LOG, Material.STRIPPED_SPRUCE_LOG, Material.STRUCTURE_BLOCK, Material.TERRACOTTA, Material.TUBE_CORAL_BLOCK, Material.WET_SPONGE, Material.WHITE_CONCRETE, Material.WHITE_CONCRETE_POWDER, Material.WHITE_GLAZED_TERRACOTTA, Material.WHITE_SHULKER_BOX, Material.WHITE_TERRACOTTA, Material.WHITE_WOOL, Material.YELLOW_CONCRETE, Material.YELLOW_CONCRETE_POWDER, Material.YELLOW_GLAZED_TERRACOTTA, Material.YELLOW_SHULKER_BOX, Material.YELLOW_TERRACOTTA, Material.YELLOW_WOOL};

    public static DyeColor strHexToDyeCol (String hex) {
        Color input = Color.decode(hex);

        double closest = 10000;
        Color closestColour = Color.decode("#000000");
        for (Color c : colours) {
            double distance = euclideanDistance(hexTodouble(input), hexTodouble(c));
            if (distance < closest) {
                closest = distance;
                closestColour = c;
            }
        }

        org.bukkit.Color c = org.bukkit.Color.fromRGB(closestColour.getRed(), closestColour.getGreen(), closestColour.getBlue());
        return DyeColor.getByColor(c);
    }

    public static Material strHexToWoolMat (String hex) {
        Color input = Color.decode(hex);

        double closest = 10000;
        int closestColour = 0;
        for (int i = 0; i < blockColours.length; i++) {
            double distance = euclideanDistance(hexTodouble(input), hexTodouble(blockColours[i]));
            if (distance < closest) {
                closest = distance;
                closestColour = i;
            }
        }

        return materials[closestColour];
    }

    private static double[] hexTodouble (Color c) {
        return new double[]{c.getRed(), c.getBlue(), c.getGreen()};
    }

    private static double euclideanDistance(double[] lab , double []lab1){
        double L = lab[0] - lab1[0];
        double A = lab[1] - lab1[1];
        double B = lab[2] - lab1[2];
        return Math.sqrt((L * L) +  (A * A) +  (B * B));
    }
}