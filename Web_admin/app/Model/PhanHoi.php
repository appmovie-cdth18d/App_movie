<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class PhanHoi extends Model
{
    use SoftDeletes;

    protected $dates = ['deleted_at'];
    
    protected $fillable = [
    	'Noidung',
		'taikhoan_id',
		'binhluan_id'
    ];

    protected function taikhoan()
	{
		$this->belongsTo('Model\TaiKhoan','taikhoan_id');
	}

	protected function binhluan()
	{
		$this->belongsTo('Model\BinhLuan','binhluan_id');
	}
}
