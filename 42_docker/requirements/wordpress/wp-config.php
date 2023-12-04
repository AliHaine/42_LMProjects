<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the installation.
 * You don't have to use the web site, you can copy this file to "wp-config.php"
 * and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * Database settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://wordpress.org/documentation/article/editing-wp-config-php/
 *
 * @package WordPress
 */

// ** Database settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define( 'DB_NAME', 'wordpress' );

/** Database username */
define( 'DB_USER', 'root' );

/** Database password */
define( 'DB_PASSWORD', 'jesuisleroot' );

/** Database hostname */
define( 'DB_HOST', 'mariadb' );

/** Database charset to use in creating database tables. */
define( 'DB_CHARSET', 'utf8mb4' );

/** The database collate type. Don't change this if in doubt. */
define( 'DB_COLLATE', '' );

/**#@+
 * Authentication unique keys and salts.
 *
 * Change these to different unique phrases! You can generate these using
 * the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}.
 *
 * You can change these at any point in time to invalidate all existing cookies.
 * This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define( 'AUTH_KEY',         '3/&{#pb.ni~N:Y=p&!~x`Z/@p+rd7x%3XM&ywAh[uhR&m3Q$:o*h!C$^/W*?)xlr' );
define( 'SECURE_AUTH_KEY',  'c6}usPzE=N= j,Zum[;B<E<V  {g8w/c1+}Dm8KjC`}2MF}xrvGtwQhx{M6w9K D' );
define( 'LOGGED_IN_KEY',    '`|FFy5!7F=Tfj~O4e#whl2X*N3l8pM]NL1!TR?!?m3a hojHCg8K8uklJ/=hL!?;' );
define( 'NONCE_KEY',        'gPm^F+E`GoT<7ITU7o>1vg.T/pi~]DU)xsU ?KBId-S8Bf>y0:9Horvim1W~n~S;' );
define( 'AUTH_SALT',        '&|EqU_&A!^f<nMOd D Cl;0CUUef5c^D{_4}+~2JLf.9xy;t0Ox6aQZsVMcw>,`Y' );
define( 'SECURE_AUTH_SALT', 'gfbbL0#UQR7v0I9S;2(W`5<B:B7jxyNj1Zm>!My<nQq2]i88L/AqGL;84n EgwKe' );
define( 'LOGGED_IN_SALT',   'r]V$754`rD&I#)P?76QPHNmo5Cy=J`?zIUccZ|#nC,NtJl2eOGT]/MpjAKkY{-fj' );
define( 'NONCE_SALT',       '}EOul?2Nl+Xw1?SU#{[x.s|c#D!_[@l,DgrtJ7{5d4w<CpgYQ`F6B_d%d%#VD([^' );

/**#@-*/

/**
 * WordPress database table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the documentation.
 *
 * @link https://wordpress.org/documentation/article/debugging-in-wordpress/
 */
define( 'WP_DEBUG', false );

/* Add any custom values between this line and the "stop editing" line. */



/* That's all, stop editing! Happy publishing. */

/** Absolute path to the WordPress directory. */
if ( ! defined( 'ABSPATH' ) ) {
        define( 'ABSPATH', __DIR__ . '/' );
}

/** Sets up WordPress vars and included files. */
require_once ABSPATH . 'wp-settings.php';