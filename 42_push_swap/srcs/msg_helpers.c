/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   msg_helpers.c                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/23 10:42:48 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/23 10:42:50 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../push_swap.h"

static void	put_str(char *msg)
{
	int	i;

	i = 0;
	while (msg[i])
	{
		write (1, &msg[i], 1);
		i++;
	}
	write (1, "\n", 1);
}

void	write_rrr(char *ac)
{
	static int	i = 0;

	if (is_str_contains(ac, "rra") || is_str_contains(ac, "rrb"))
	{
		if (i == 0)
		{
			if (is_str_contains(ac, "rrb"))
				put_str("rrb");
			else
				put_str("rra");
		}
		else
			i--;
	}
	else if (is_str_contains(ac, "rrr"))
	{
		put_str("rrr");
		i++;
	}
}

void	write_rr(char *ac)
{
	static int	i = 0;

	if (is_str_contains(ac, "ra") || is_str_contains(ac, "rb"))
	{
		if (i == 0)
		{
			if (is_str_contains(ac, "rb"))
				put_str("rb");
			else
				put_str("ra");
		}
		else
			i--;
	}
	else if (is_str_contains(ac, "rr"))
	{
		put_str("rr");
		i++;
	}
}

void	write_ss(char *ac)
{
	static int	i = 0;

	if (is_str_contains(ac, "sa") || is_str_contains(ac, "sb"))
	{
		if (i == 0)
		{
			if (is_str_contains(ac, "sb"))
				put_str("sb");
			else
				put_str("sa");
		}
		else
			i--;
	}
	else if (is_str_contains(ac, "ss"))
	{
		put_str("ss");
		i++;
	}
}
