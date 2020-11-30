package io.github.tehcjs.fabricpvp.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class FakeEntity extends Entity {

	public static final FakeEntity INSTANCE = new FakeEntity();

	public FakeEntity() {
		super(null);
	}

	@Override
	protected void initDataTracker() {

	}

	@Override
	protected void deserialize(CompoundTag tag) {

	}

	@Override
	protected void serialize(CompoundTag tag) {

	}
}
