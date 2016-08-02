/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var allaudio;
var allplaylist;
var alltracks;
var allcurrent;

allinit();
$("#add,#my,#search").click(function () {
    allaudio = $('#allaudio');
    allplaylist = $('#allplaylist');
    tracks = playlist.find('li a');
    allaudio[0].pause();
});
function allinit(){
    current = 0;
    allaudio = $('#allaudio');
    allplaylist = $('#allplaylist');
    alltracks = allplaylist.find('li a');
    len = alltracks.length - 1;
    allaudio[0].volume = .50;
    allaudio[0].pause();
    allplaylist.find('li a').click(function(e){
        e.preventDefault();
        link = $(this);
        current = link.parent().index();
        allrun(link, allaudio[0]);
    });
    allaudio[0].addEventListener('ended',function(e){
        current++;
        if(current == len){
            current = 0;
            link = allplaylist.find('li a')[0];
        }else{
            link = allplaylist.find('li a')[current];    
        }
        allrun($(link),allaudio[0]);
    });
}
function allrun(link, player){
        player.src = link.attr('href');
        par = link.parent();
        par.addClass('active').siblings().removeClass('active');
        allaudio[0].load();
        allaudio[0].play();
}