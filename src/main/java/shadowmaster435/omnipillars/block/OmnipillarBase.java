package shadowmaster435.omnipillars.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import shadowmaster435.omnipillars.util.ConnectableSide;
import shadowmaster435.omnipillars.util.MiscUtil;

public class OmnipillarBase extends Block {
    public static final EnumProperty<ConnectableSide> UP;
    public static final EnumProperty<ConnectableSide> DOWN;
    public static final EnumProperty<ConnectableSide> NORTH;
    public static final EnumProperty<ConnectableSide> SOUTH;
    public static final EnumProperty<ConnectableSide> EAST;
    public static final EnumProperty<ConnectableSide> WEST;

    static {
        UP = EnumProperty.of("up", ConnectableSide.class);
        DOWN = EnumProperty.of("down", ConnectableSide.class);
        NORTH = EnumProperty.of("north", ConnectableSide.class);
        SOUTH = EnumProperty.of("south", ConnectableSide.class);
        EAST = EnumProperty.of("east", ConnectableSide.class);
        WEST = EnumProperty.of("west", ConnectableSide.class);
    }
    public OmnipillarBase(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(UP, ConnectableSide.NONE)
                .with(DOWN, ConnectableSide.NONE)
                .with(NORTH, ConnectableSide.NONE)
                .with(SOUTH, ConnectableSide.NONE)
                .with(EAST, ConnectableSide.NONE)
                .with(WEST, ConnectableSide.NONE));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(UP, DOWN, NORTH, SOUTH, EAST, WEST);
    }


    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        Direction dir2 = MiscUtil.getBlockHitResult(world, placer).getSide();
        for (Direction dir : Direction.values()) {
            assert placer != null;
           if (dir == MiscUtil.getBlockHitResult(world, placer).getSide()) {
                if (MiscUtil.IsBlockAtPos(this, pos.offset(dir2.getOpposite()), world)) {
                    if (MiscUtil.IsBlockAtPos(this, pos.offset(dir2), world)) {
                        world.setBlockState(pos, state.with(getProperty(dir2.getOpposite()), ConnectableSide.CONNECTED).with(getProperty(dir2), ConnectableSide.CONNECTED));
                    } else {
                        world.setBlockState(pos, state.with(getProperty(dir2.getOpposite()), ConnectableSide.CONNECTED).with(getProperty(dir2), ConnectableSide.CAP));

                    }
                    world.setBlockState(pos.offset(dir.getOpposite()), world.getBlockState(pos.offset(dir.getOpposite())).with(getProperty(dir2), ConnectableSide.CONNECTED));
                } else {
                    world.setBlockState(pos, state.with(getProperty(dir2.getOpposite()), ConnectableSide.CAP));
                    if (MiscUtil.IsBlockAtPos(this, pos.offset(dir2.getOpposite()), world)) {
                        world.setBlockState(pos.offset(dir.getOpposite()), world.getBlockState(pos.offset(dir.getOpposite())).with(getProperty(dir2), ConnectableSide.CAP));
                    }

                }

            }

            }
        }

    public static EnumProperty<ConnectableSide> getProperty(Direction facing) {

        return switch (facing) {
            case UP -> UP;
            case DOWN -> DOWN;
            case EAST -> EAST;
            case WEST -> WEST;
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
        };
    }
}
