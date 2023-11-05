/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   splitter_bonus.c                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/27 15:46:04 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/27 15:46:07 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../push_swap_bonus.h"

static long long int	get_number_from_single(char *argv, int *i)
{
	long long int	nbr;
	short			sign;

	sign = 1;
	nbr = 0;
	if (argv[*i] == '-')
	{
		sign = -1;
		*i = *i + 1;
	}
	while (argv[*i])
	{
		if (argv[*i] == ' ')
			break ;
		else
		{
			nbr = (nbr + (argv[*i] - '0')) * 10;
		}
		*i = *i + 1;
	}
	return ((nbr / 10) * sign);
}

static bool	is_number_single(char *s, int i)
{
	if (s[i] == '-')
		i++;
	if (s[i] == ' ')
		return (false);
	while (s[i])
	{
		if (is_digit(s[i]) == false)
			return (false);
		i++;
		if (s[i] == ' ')
			break ;
	}
	return (true);
}

int	load_main_splitter_bonus(char *argv, struct s_core *core, int i)
{
	long long int	n;

	while (argv[i])
	{
		if (is_number_single(argv, i) == false)
			error_manager(ERROR_NOT_NBR, core);
		n = get_number_from_single(argv, &i);
		if (n > 2147483647 || n < -2147483648)
			return (0);
		if (is_val_alr(n, core->p1) == true)
			error_manager(ERROR_ALR_NBR, core);
		if (!create_new_cont(n, core->p1))
			return (0);
		if (argv[i])
			i++;
	}
	return (1);
}
