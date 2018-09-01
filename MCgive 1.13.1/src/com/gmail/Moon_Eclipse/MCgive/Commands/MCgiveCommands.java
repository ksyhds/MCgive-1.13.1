package com.gmail.Moon_Eclipse.MCgive.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.Moon_Eclipse.MCgive.MCgive;
import com.gmail.Moon_Eclipse.MCgive.ItemDeliver.ItemDeliver;

public class MCgiveCommands implements CommandExecutor
{
	MCgive plugin;
	
	public MCgiveCommands (MCgive instance)
	{
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		// 만약 커맨드 입력자가 관리자라면
	    if(sender.isOp())
	    {
	    	// 만약 커맨드 이름이 주기 라면
	    	if(command.getName().equalsIgnoreCase("주기"))
			{
	    		// 주기 이외에 아무것도 입력되지 않거나 ?,help가 입력되었다면
	    		if( args.length < 1 || args[0].equalsIgnoreCase("?") || args[0].equalsIgnoreCase("help"))
				{	
	    			sender.sendMessage("/주기 코드 - 손에 든 아이템의 아이템 이름을 알려줍니다.");
					sender.sendMessage("/주기 리로드 - 리로드");
					sender.sendMessage("/주기 플레이어이름 아이템이름 개수- 아이템을 받아옵니다. 개수를 0으로 설정하면 config파일에 적힌 개수만큼 가져옵니다.");
				}
	    		if(args.length == 1)
				{
					switch(args[0])
					{
						case "리로드":
							plugin.Plugin_Reload();
							sender.sendMessage("MCgive reload");
						break;
						case "코드":
							Player player = (Player) sender;
							sender.sendMessage(player.getEquipment().getItemInMainHand().getType().name());
						break;
					}
				}
	    		else if (args.length >= 2)
		        {
	    			// 아이템을 넘겨줄 대상을 저장해둠
	    			Player Target_Player = Bukkit.getPlayer(args[0]);
	    			
					// 주기 플레이어이름 아이템이름 개수
					int amount = Integer.parseInt(args[2]);
					ItemDeliver.Send_Item(Target_Player, args[1], amount);
		        }
	    	}
	    }
		return true;
	}
}
