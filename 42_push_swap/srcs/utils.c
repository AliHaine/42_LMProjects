/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   utils.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/21 15:43:40 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/21 15:43:42 by ayagmur          ###   ########.fr       */
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

bool	is_str_contains(char *src, char *val)
{
	int	i;

	i = 0;
	while (src[i])
	{
		if (val[i] != src[i])
			return (false);
		i++;
	}
	return (true);
}

void	action_writter(char *ac, bool write)
{
	if (write == false)
		return ;
	if (is_str_contains(ac, "sa") || is_str_contains(ac, "sb")
		|| is_str_contains(ac, "ss"))
	{
		write_ss(ac);
	}
	else if (is_str_contains(ac, "pa"))
		put_str("pa");
	else if (is_str_contains(ac, "pb"))
		put_str("pb");
	else if (is_str_contains(ac, "ra") || is_str_contains(ac, "rb")
		|| is_str_contains(ac, "rr"))
	{
		write_rr(ac);
	}
	else if (is_str_contains(ac, "rra") || is_str_contains(ac, "rrb")
		|| is_str_contains(ac, "rrr"))
	{
		write_rrr(ac);
	}
}

long long int	ft_atoi(char *s)
{
	int					i;
	long long int		result;
	short				sign;

	i = 0;
	result = 0;
	sign = 1;
	if (s[i] == '-')
	{
		sign = -1;
		i++;
	}
	while (s[i])
	{
		result = (result + (s[i] - '0')) * 10;
		i++;
	}
	return ((result / 10) * sign);
}

void	error_manager(char *msg, t_core *core)
{
	write(1, "Error\n", 6);
	put_str(msg);
	free_struct(core);
	exit(1);
}
