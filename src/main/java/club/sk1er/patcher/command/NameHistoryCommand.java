package club.sk1er.patcher.command;

import club.sk1er.mods.core.ModCore;
import club.sk1er.mods.core.util.MinecraftUtils;
import club.sk1er.patcher.screen.ScreenHistory;
import java.util.Arrays;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumChatFormatting;

public class NameHistoryCommand extends CommandBase {

  @Override
  public String getCommandName() {
    return "names";
  }

  @Override
  public String getCommandUsage(ICommandSender iCommandSender) {
    return "/names <username>";
  }

  @Override
  public void processCommand(ICommandSender iCommandSender, String[] strings) {
    switch (strings.length) {
      case 0:
        ModCore.getInstance().getGuiHandler().open(new ScreenHistory());
        break;

      case 1:
        ModCore.getInstance().getGuiHandler().open(new ScreenHistory(strings[0]));
        break;

      default:
        MinecraftUtils
            .sendMessage(EnumChatFormatting.YELLOW + "[Patcher] ", "Usage: /name <username>");
        break;
    }
  }

  @Override
  public List<String> getCommandAliases() {
    return Arrays.asList("namehistory", "name", "username", "history");
  }

  @Override
  public int getRequiredPermissionLevel() {
    return -1;
  }
}