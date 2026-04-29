/*
 * Problem: 2669. Count Artist Occurrences On Spotify Ranking List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-artist-occurrences-on-spotify-ranking-list/
 * Language: mysql
 * Date: 2026-04-29
 */

# Write your MySQL query statement below
select artist, COUNT(*) as occurrences
from Spotify
group by artist
order by occurrences desc, artist
