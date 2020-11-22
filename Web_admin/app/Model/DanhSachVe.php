<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class DanhSachVe extends Model
{
    use SoftDeletes;
    
    protected $dates = ['deleted_at'];

    protected $fillable = [
    	'Soluong',
		'Tongtien',
		'taikhoan_id'
    ];

    protected function Ve()
	{
		$this->hasMany('Model\Ve','dsve_id','id');
	}

    protected function taikhoan()
	{
		$this->belongsTo('Model\TaiKhoan','taikhoan_id');
	}
}
