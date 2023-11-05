/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   brain_short.c                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/25 15:31:34 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/25 15:31:36 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../../push_swap.h"

static bool	is_low(t_core *core)
{
	t_cont	*iterator;
	int		nn;

	iterator = core->p1->first;
	nn = core->p2->first->nn;
	while (iterator)
	{
		if (iterator->nn < nn)
			return (false);
		iterator = iterator->next;
	}
	return (true);
}

static void	make_ac(t_core *core)
{
	t_cont	*iterator;
	int		nn;
	int		i;

	nn = core->p2->first->nn;
	iterator = core->p1->first;
	i = 0;
	while (iterator)
	{
		if (iterator->nn == nn + 1)
			break ;
		i++;
		iterator = iterator->next;
	}
	action_spammer("ra", i, core);
	push_elem(2, core, true);
	action_spammer("rra", i, core);
}

int	brain_short(t_core *core)
{
	bool	is_lower;

	is_lower = true;
	while (core->p2->size > 0)
	{
		is_lower = is_low(core);
		if (is_lower == true)
			push_elem(2, core, true);
		else
			make_ac(core);
	}
	return (0);
}
