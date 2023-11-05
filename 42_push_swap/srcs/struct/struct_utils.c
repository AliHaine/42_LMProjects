/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   struct_utils.c                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/21 15:44:01 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/21 15:44:02 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../../push_swap.h"

void	free_struct(t_core *core)
{
	t_cont	*iterator;
	t_cont	*tofree;

	iterator = core->p1->first;
	while (iterator)
	{
		if (iterator->next == NULL)
			break ;
		tofree = iterator;
		iterator = iterator->next;
		free(tofree);
	}
	free(iterator);
}

void	update_index(struct s_pile *p, int i)
{
	t_cont	*iterator;

	iterator = p->first;
	while (iterator)
	{
		iterator->index = iterator->index + i;
		iterator = iterator->next;
	}
}

t_cont	*get_cont_from_index(struct s_pile *p, int index)
{
	t_cont	*iterator;

	iterator = p->first;
	while (iterator)
	{
		if (iterator->index == index)
			return (iterator);
		iterator = iterator->next;
	}
	return (0);
}

bool	is_val_alr(int i, struct s_pile *p)
{
	t_cont	*iterator;

	iterator = p->first;
	while (iterator)
	{
		if (iterator->val == i)
			return (true);
		iterator = iterator->next;
	}
	return (false);
}

void	action_spammer(char *str, int count, t_core *core)
{
	while (count > 0)
	{
		if (is_str_contains(str, "pa"))
			push_elem(2, core, true);
		else if (is_str_contains(str, "pb"))
			push_elem(1, core, true);
		else if (is_str_contains(str, "ra"))
			rotate_elem(1, core, true);
		else if (is_str_contains(str, "rb"))
			rotate_elem(2, core, true);
		else if (is_str_contains(str, "rr"))
			rotate_elem(3, core, true);
		else if (is_str_contains(str, "rra"))
			reverse_rotate_elem(1, core, true);
		else if (is_str_contains(str, "rrb"))
			reverse_rotate_elem(2, core, true);
		else if (is_str_contains(str, "rrr"))
			reverse_rotate_elem(3, core, true);
		else if (is_str_contains(str, "sa"))
			swap_elem(1, core, true);
		else if (is_str_contains(str, "sb"))
			swap_elem(2, core, true);
		count--;
	}
}
