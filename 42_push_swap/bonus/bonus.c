/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   bonus.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/25 17:29:30 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/25 17:29:33 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../push_swap_bonus.h"

static void	input_controller_helper(char *ac, t_core *core, bool a, bool b)
{
	if (!a)
	{
		if (is_str_contains(ac, "pb\n"))
			push_elem(1, core, false);
		else if (is_str_contains(ac, "ra\n"))
			rotate_elem(1, core, false);
		else if (is_str_contains(ac, "rra\n"))
			reverse_rotate_elem(1, core, false);
		else if (is_str_contains(ac, "sa\n"))
			swap_elem(1, core, false);
	}
	if (!a && !b)
	{
		if (is_str_contains(ac, "ss\n"))
			swap_elem(3, core, false);
		else if (is_str_contains(ac, "rrr\n"))
			reverse_rotate_elem(3, core, false);
		else if (is_str_contains(ac, "rr\n"))
			rotate_elem(3, core, false);
	}
}

static void	input_controller(char *ac, t_core *core)
{
	bool	is_nulla;
	bool	is_nullb;

	is_nulla = true;
	is_nullb = true;
	if (core->p1->size > 0)
		is_nulla = false;
	if (core->p2->size > 0)
		is_nullb = false;
	if (!is_nullb)
	{
		if (is_str_contains(ac, "pa\n"))
			push_elem(2, core, false);
		else if (is_str_contains(ac, "rb\n"))
			rotate_elem(2, core, false);
		else if (is_str_contains(ac, "rrb\n"))
			reverse_rotate_elem(2, core, false);
		else if (is_str_contains(ac, "sb\n"))
			swap_elem(2, core, false);
	}
	input_controller_helper(ac, core, is_nulla, is_nullb);
}

static void	init_struct_def_val(t_core *core)
{
	core->p1->first = NULL;
	core->p1->last = NULL;
	core->p2->first = NULL;
	core->p2->last = NULL;
	core->p1->size = 0;
	core->p2->size = 0;
}

static void	pre_load(t_core *core, char **argv, int argc)
{
	if (argc == 2)
		load_main_splitter_bonus(argv[1], core, 0);
	else
		load_main_bonus(argv, core, 1);
	set_nn_bonus(core->p1, 1, 0, 0);
}

int	main(int argc, char **argv)
{
	char	*line;
	t_core	core;
	t_pile	p1;
	t_pile	p2;

	core.p1 = &p1;
	core.p2 = &p2;
	if (argc < 2)
		return (0);
	init_struct_def_val(&core);
	pre_load(&core, argv, argc);
	line = get_next_line(0);
	while (line)
	{
		input_controller(line, &core);
		free(line);
		line = get_next_line(0);
	}
	if (is_sort_bonus(core.p1) && core.p2->size == 0)
		write(1, "OK\n", 3);
	else
		write(1, "KO\n", 3);
	free_struct(&core);
	return (0);
}
