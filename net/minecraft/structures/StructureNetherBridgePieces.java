package net.minecraft.structures;

import net.minecraft.components.ComponentNetherBridgeThrone;
import net.minecraft.components.ComponentNetherBridgeNetherStalkRoom;
import net.minecraft.components.ComponentNetherBridgeCrossing2;
import net.minecraft.components.ComponentNetherBridgeStraight;
import net.minecraft.components.ComponentNetherBridgeCrossing;
import net.minecraft.components.ComponentNetherBridgeCorridor3;
import net.minecraft.components.ComponentNetherBridgeStairs;
import net.minecraft.components.ComponentNetherBridgeCorridor2;
import net.minecraft.components.ComponentNetherBridgePiece;
import net.minecraft.components.ComponentNetherBridgeCorridor;
import net.minecraft.components.ComponentNetherBridgeCrossing3;
import net.minecraft.components.ComponentNetherBridgeCorridor5;
import net.minecraft.components.ComponentNetherBridgeCorridor4;
import net.minecraft.components.ComponentNetherBridgeEntrance;
import java.util.List;
import java.util.Random;

public class StructureNetherBridgePieces
{
    public static final StructureNetherBridgePieceWeight primaryComponents[];
    public static final StructureNetherBridgePieceWeight secondaryComponents[];

    public StructureNetherBridgePieces()
    {
    }

    public static ComponentNetherBridgePiece createNextComponentRandom(StructureNetherBridgePieceWeight par0StructureNetherBridgePieceWeight, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        Class class1 = par0StructureNetherBridgePieceWeight.field_40699_a;
        Object obj = null;

        if (class1 == (net.minecraft.components.ComponentNetherBridgeStraight.class))
        {
            obj = ComponentNetherBridgeStraight.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeCrossing3.class))
        {
            obj = ComponentNetherBridgeCrossing3.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeCrossing.class))
        {
            obj = ComponentNetherBridgeCrossing.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeStairs.class))
        {
            obj = ComponentNetherBridgeStairs.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeThrone.class))
        {
            obj = ComponentNetherBridgeThrone.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeEntrance.class))
        {
            obj = ComponentNetherBridgeEntrance.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeCorridor5.class))
        {
            obj = ComponentNetherBridgeCorridor5.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeCorridor2.class))
        {
            obj = ComponentNetherBridgeCorridor2.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeCorridor.class))
        {
            obj = ComponentNetherBridgeCorridor.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeCorridor3.class))
        {
            obj = ComponentNetherBridgeCorridor3.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeCorridor4.class))
        {
            obj = ComponentNetherBridgeCorridor4.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeCrossing2.class))
        {
            obj = ComponentNetherBridgeCrossing2.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }
        else if (class1 == (net.minecraft.components.ComponentNetherBridgeNetherStalkRoom.class))
        {
            obj = ComponentNetherBridgeNetherStalkRoom.createValidComponent(par1List, par2Random, par3, par4, par5, par6, par7);
        }

        return ((ComponentNetherBridgePiece)(obj));
    }

    public static ComponentNetherBridgePiece createNextComponent(StructureNetherBridgePieceWeight par0StructureNetherBridgePieceWeight, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return createNextComponentRandom(par0StructureNetherBridgePieceWeight, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    public static StructureNetherBridgePieceWeight[] getPrimaryComponents()
    {
        return primaryComponents;
    }

    public static StructureNetherBridgePieceWeight[] getSecondaryComponents()
    {
        return secondaryComponents;
    }

    static
    {
        primaryComponents = (new StructureNetherBridgePieceWeight[]
                {
                    new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeStraight.class, 30, 0, true), new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeCrossing3.class, 10, 4), new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeCrossing.class, 10, 4), new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeStairs.class, 10, 3), new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeThrone.class, 5, 2), new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeEntrance.class, 5, 1)
                });
        secondaryComponents = (new StructureNetherBridgePieceWeight[]
                {
                    new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeCorridor5.class, 25, 0, true), new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeCrossing2.class, 15, 5), new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeCorridor2.class, 5, 10), new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeCorridor.class, 5, 10), new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeCorridor3.class, 10, 3, true), new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeCorridor4.class, 7, 2), new StructureNetherBridgePieceWeight(net.minecraft.components.ComponentNetherBridgeNetherStalkRoom.class, 5, 2)
                });
    }
}
