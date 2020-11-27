<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class Phim extends Model
{
    use SoftDeletes;

    protected $dates = ['deleted_at'];
    
    protected $fillable = [
    	'Tenphim',
        'Hinhanh',
		'Diem',
		'Mota',
		'Trailer',
		'ThoiLuong',
        'daodien_id',
		'dinhdang_id',
		'trangthai_id',
		'Theloai_id'
    ];

    public function binhluans(){
        return $this->hasMany('Model\BinhLuan','phim_id','id');
    }

    public function daodien(){
        return $this->belongsto('Model\DaoDien','daodien_id','id');
    }

    protected function lichchieus()
    {
        $this->hasMany('Model\LichChieu','phim_id','id');
    }

    public function trangthaiphim(){
    	return $this->belongsto('Model\TrangThaiPhim','trangthai_id');
    }

    public function theloai(){
    	return $this->belongsto('Model\TheLoaiPhim','Theloai_id');
    }

    public function dinhdang(){
    	return $this->belongsto('Model\DinhDangPhim','dinhdang_id');
    }
}
