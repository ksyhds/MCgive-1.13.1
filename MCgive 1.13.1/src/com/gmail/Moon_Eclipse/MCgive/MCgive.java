package com.gmail.Moon_Eclipse.MCgive;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import com.Moon_Eclipse.MCgive.ItemDeliver.ItemDeliver;
import com.gmail.Moon_Eclipse.Commands.MCgiveCommands;

public class MCgive extends JavaPlugin
{
	// 콘픽을 저장하기 위한 변수 선언
	static Configuration c;
	
	// 인스턴스 반환을 위한 변수 선언
	static MCgive instance;
	
	// 플러그인이 로딩되면
	public void onEnable()
	{
		// 커맨드 클래스를 설정
		getCommand("주기").setExecutor(new MCgiveCommands(this));
		
		// 콘픽이 없다면 새로 저장
		this.saveDefaultConfig();
		
		// 콘픽을 불러와 저장
		c = this.getConfig();
		
		// 리로드 과정을 통해 각 값들을 초기화
		Plugin_Reload();
		
		instance = this;
	}
	
	// 서버가 꺼지면
	public void onDisable(){ }
	
	// 플러그인 커맨드에 의해 리로드 될 경우
	public void Plugin_Reload()
	{
		// 콘픽 리로드
		this.reloadConfig();
		
		// 변경된 콘픽을 변수에 덮어씀
		c = this.getConfig();
		
		ItemDeliver.config = c;
		
	}
	
	// 플러그인 인스턴스를 보내기위해 메소드 생성
	public static MCgive getInstance()
	{
		return instance;
	}
	
}
