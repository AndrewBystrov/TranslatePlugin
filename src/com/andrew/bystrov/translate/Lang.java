package com.andrew.bystrov.translate;

public class Lang
{
	private String name;
	private String direction;

	public Lang(String name, String direction)
	{
		this.name = name;
		this.direction = direction;
	}

	public String getDirection()
	{
		return direction;
	}

	@Override
	public String toString()
	{
		return this.name;
	}
}
