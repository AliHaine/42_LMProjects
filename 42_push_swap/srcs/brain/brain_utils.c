/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   brain_utils.c                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/21 15:42:40 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/21 15:42:42 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../../push_swap.h"

void	set_topush_bb(int spam, int index, t_core *core)
{
	if (index >= core->p2->size / 2)
		action_spammer("rrb", spam, core);
	else
		action_spammer("rb", spam, core);
}

bool	is_less_nn(int nn, t_pile *p)
{
	t_cont	*iterator;

	iterator = p->first;
	while (iterator)
	{
		if (iterator->nn < nn)
			return (false);
		iterator = iterator->next;
	}
	return (true);
}

bool	is_bigger_nn(int nn, t_pile *p)
{
	t_cont	*iterator;

	iterator = p->first;
	while (iterator)
	{
		if (iterator->nn > nn)
			return (false);
		iterator = iterator->next;
	}
	return (true);
}

bool	sncf_grp(t_core *core)
{
	t_cont	*iterator;
	int		i;

	iterator = core->p2->first;
	i = 0;
	while (i++ < 10)
	{
		if (iterator->nn < core->p1->first->nn
			&& iterator->nn > core->p1->last->nn)
		{
			set_topush_bb(iterator->index - 1, iterator->index - 1, core);
			return (true);
		}
	}
	return (false);
}

void	set_to_last(t_core *core)
{
	push_elem(2, core, true);
	rotate_elem(1, core, true);
}
