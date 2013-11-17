package net.minecraft.block;

import net.minecraft.block.material.Material;

public class BlockHay extends Block {
    public BlockHay (int par1, int par2) {
        super(par1, par2, Material.grass);
    }
    
    @Override
    public int getBlockTextureFromSide(int par1) {
        if (par1 == 0) {
            return blockIndexInTexture + 1;
        } if (par1 == 1) {
            return blockIndexInTexture + 1;
        } else {
            return blockIndexInTexture;
        }
    }
}
