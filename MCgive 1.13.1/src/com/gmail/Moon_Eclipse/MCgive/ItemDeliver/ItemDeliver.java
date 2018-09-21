package com.gmail.Moon_Eclipse.MCgive.ItemDeliver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.Moon_eclipse.EclipseLib.ItemCreater.*;

public class ItemDeliver 
{
	// 리로드 시에 콘픽을 저장받기위한 공간을 생성
	public static Configuration config;
	
	// 아이템을 플레이어에게 직접 보내는 메소드
	public static void Send_Item(Player Target_Player, String ItemName, int Amount)
	{
		// 아이템 이름을 기반으로 config에서 아이템을 생성받아옴
		ItemStack Created_Item = ItemCreat_From_Config(ItemName, Amount);
		
		
		
		// 플레이어에게 아이템을 지급함
		Target_Player.getInventory().addItem(Created_Item);
	}
	
	// 보낼 아이템을 생성하는 메소드
	public static ItemStack ItemCreat_From_Config(String ItemName, int Amount)
	{
		
		// 아이템의 이름이 정해져 있으므로 반복문이 필요 없음. 따라서 아래 구문을 주석 처리함.
		// 섹션의 항목을 key로 설정
		String key = "config." + ItemName;
		
		
		String Material_Name = config.getString(key + ".Material_Name");
		short Damage = (short) config.getInt(key + ".metadata");
		int Alternative_Amount = config.getInt(key + ".Amount");
		String Display_Name = config.getString(key + ".name");
		List<String> Lore = config.getStringList(key + ".lore");
		String ColorHex = config.getString(key + ".color");
		String SkullURL = config.getString(key + ".URL");
		List<String> Enchants = config.getStringList(key + ".enchants");
	
		if(Amount == 0)
		{
			Amount = Alternative_Amount;  
		}			
		ItemStack Created_Item = ItemCreator.Create_ItemStack(Material_Name, Alternative_Amount, Damage, Display_Name, Lore, ColorHex, SkullURL, Enchants);
		return Created_Item;
		
		/*
		// 검색을 위해 콘픽 섹션을 가져옴
		Set<String> keys = config.getConfigurationSection("config.").getKeys(false);
		
		// 콘픽에 이상이 없는지 검사
		if ((keys == null) || (keys.isEmpty()))
	    {
	      System.out.println("콘피그 파일에 이상이 있습니다.");
	    }
		
		// 섹션의 각 항목을 불러서 반복
		for(String C_Item_Name : keys)
		{
			// 쓸데없는 연산을 피하기 위해 요청된 항목이 아니면 다음 항목으로 이동
			if(!C_Item_Name.equals(ItemName))
			{
				continue;
			}
			
			// 섹션의 항목을 key로 설정
			String key = "config." + C_Item_Name;
			
			
			String Material_Name = config.getString(key + ".Material_Name");
			short Damage = (short) config.getInt(key + ".metadata");
			int Alternative_Amount = config.getInt(key + ".Amount");
			String Display_Name = config.getString(key + ".name");
			List<String> Lore = config.getStringList(key + ".lore");
			String ColorHex = config.getString(key + ".color");
			String SkullURL = config.getString(key + ".URL");
			List<String> Enchants = config.getStringList(key + ".enchants");
		
			if(Amount == 0)
			{
				Amount = Alternative_Amount;  
			}			
			ItemStack Created_Item = ItemCreator.Create_ItemStack(Material_Name, Alternative_Amount, Damage, Display_Name, Lore, ColorHex, SkullURL, Enchants);
			return Created_Item;
		}
		*/		
	}
}
