<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletess;

class BinhLuan extends Model
{
	use SoftDeletes;
	protected $dates = ['deleted_at'];
	
	protected $fillable = [
		'Noidung',
		'Ngaydang',
		'taikhoan_id',
		'phim_id'
	];

	protected function phim()
	{
		$this->belongsTo('Model\Phim','phim_id');
	}

	protected function taikhoan()
	{
		$this->belongsTo('Model\TaiKhoan','taikhoan_id');
	}

	protected function phanhois()
	{
		$this->hasMany('Model\PhanHoi','binhluan_id','id');
	}
}
