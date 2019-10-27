package com.hx.hkTest.yingshi.util.api;

import java.util.List;

import org.junit.Test;

import com.hx.hkTest.yingshi.dto.live.LiveVideoListDto;

public class LiveApiTest {

	@Test
	public void liveVideoList(){
		String pageStart = "0";
		String pageSize = "10";
		List<LiveVideoListDto> vodeoList = LiveApi.liveVideoList(pageStart, pageSize);
		System.out.println(vodeoList);
	}
}
