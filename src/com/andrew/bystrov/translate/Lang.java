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

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Lang lang = (Lang) o;

		return name != null ? name.equals(lang.name) : lang.name == null;
	}

	@Override
	public int hashCode()
	{
		return name != null ? name.hashCode() : 0;
	}
}
