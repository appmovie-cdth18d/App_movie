<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class Ve extends Model
{
    use SoftDeletes;

    protected $dates = ['deleted_at'];
    
    protected $fillable = [
		'dsve_id',
		'lichchieu_id',
		'Thanhtien'
    ];

    protected function danhsachve(){
    	$this->belongsTo('Model\DanhSachVe','dsve_id');
    }

    protected function lichchieu(){
   		$this->belongsTo('Model\DanhSachVe','lichchieu_id');

}
