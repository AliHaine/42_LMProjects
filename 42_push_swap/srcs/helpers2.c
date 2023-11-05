/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   helpers2.c                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/27 15:49:49 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/27 15:49:51 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../push_swap.h"

void	set_topush_b(int spam, int index, t_core *core)
{
	if (index >= core->p2->size / 2)
		action_spammer("rrb", spam, core);
	else
		action_spammer("rb", spam, core);
}

void	set_toreceive_a(int spam, t_core *core, int place)
{
	if (place >= core->p1->size / 2)
		action_spammer("rra", spam, core);
	else
		action_spammer("ra", spam, core);
}

static void	set_base_pile(t_core *core, int i, int size)
{
	size = core->p1->size / 2;
	if (core->p1->size == 4)
	{
		push_elem(1, core, true);
		return ;
	}
	while (1)
	{
		if (core->p1->first->nn <= size)
		{
			push_elem(1, core, true);
			i++;
			if (i == size)
				break ;
		}
		else
			rotate_elem(1, core, true);
	}
	size = core->p1->size;
	while (size != 3)
	{
		push_elem(1, core, true);
		size--;
	}
}

void	loader_line(t_core *core)
{
	set_base_pile(core, 0, 0);
	sort_base_pile(core);
}
