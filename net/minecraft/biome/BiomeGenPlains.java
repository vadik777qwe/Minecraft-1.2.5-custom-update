package net.minecraft.biome;

public class BiomeGenPlains extends BiomeGenBase {
	protected BiomeGenPlains(int par1) {
		super(par1);
		biomeDecorator.treesPerChunk = -999;
		biomeDecorator.flowersPerChunk = 32;
		biomeDecorator.grassPerChunk = 10;
	}
}
