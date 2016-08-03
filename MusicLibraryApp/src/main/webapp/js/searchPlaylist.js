/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var searchaudio;
var searchplaylist;
var searchtracks;
var searchcurrent;

searchinit();
$("#add,#my,#all").click(function () {
    searchaudio = $('#searchaudio');
    searchplaylist = $('#searchplaylist');
    tracks = playlist.find('li a');
    searchaudio[0].pause();
});
function searchinit(){
    current = 0;
    searchaudio = $('#searchaudio');
    searchplaylist = $('#searchplaylist');
    searchtracks = searchplaylist.find('li a');
    len = searchtracks.length - 1;
    searchaudio[0].volume = .50;
    searchaudio[0].pause();
    searchplaylist.find('li a').click(function(e){
        e.preventDefault();
        link = $(this);
        current = link.parent().index();
        searchrun(link, searchaudio[0]);
    });
    searchaudio[0].addEventListener('ended',function(e){
        current++;
        if(current == len){
            current = 0;
            link = searchplaylist.find('li a')[0];
        }else{
            link = searchplaylist.find('li a')[current];    
        }
        searchrun($(link),searchaudio[0]);
    });
}
function searchrun(link, player){
        player.src = link.attr('href');
        par = link.parent();
        par.addClass('active').siblings().removeClass('active');
        searchaudio[0].load();
        searchaudio[0].play();
}