<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class TaiKhoan extends Model
{
    use SoftDeletes;

    protected $dates = ['deleted_at'];
    
    protected $filable = [
		'HoTen',
        'Ten_TK',
		'Matkhau',
		'Email',
		'Ngaysinh',
		'Phai',
		'SDT',
		'Diachi'
    ];

    public function binhluans(){
        return $this->hasMany('Model\BinhLuan','taikhoan_id','id');
    }
    public function phanhois(){
        return $this->hasMany('Model\PhanHoi','taikhoan_id','id');
    }
    public function danhsachves(){
        return $this->hasMany('Model\DanhSachVe','taikhoan_id','id');
    }
}
