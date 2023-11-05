/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   minitalk_client_bonus.c                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/12/16 13:42:55 by ayagmur           #+#    #+#             */
/*   Updated: 2022/12/16 13:42:57 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "minitalk_bonus.h"

void	confirm_msg(const int i)
{
	static int	o = 0;
	static int	a = 0;

	if (o == 0)
		o = i;
	if (a == o)
	{
		ft_printf("Votre message a été reçu.");
		exit(1);
	}
	a++;
}

int	read_bit(int pid, char c)
{
	int	b;

	b = 7;
	while (b >= 0)
	{
		if (c >> b & 1)
			kill(pid, SIGUSR1);
		else
			kill(pid, SIGUSR2);
		b--;
		usleep(200);
	}
	return (0);
}

int	main(int argc, char *argv[])
{
	int	i;

	i = 0;
	signal(SIGUSR2, confirm_msg);
	if (argc != 3)
	{
		ft_printf("Erreur avec les arguments");
		return (0);
	}
	while (argv[2][i])
		i++;
	confirm_msg(i);
	i = 0;
	while (argv[2][i])
	{
		read_bit(ft_atoi(argv[1]), argv[2][i]);
		i++;
	}
	while (1)
		pause();
	return (0);
}
